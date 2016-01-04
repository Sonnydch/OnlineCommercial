package com.du.mall.action;

import com.du.mall.entity.Picture;
import com.du.mall.entity.Product;
import com.du.mall.entity.User;
import com.du.mall.service.PictureService;
import com.du.mall.service.ProductService;
import com.du.mall.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sonny on 2015/12/26.
 */
public class ProductAction extends ActionSupport implements ServletRequestAware {

  private Product product;
  private ProductService productService;
  private String message;
  private List<Product> productList;
  private List<Picture> pictureList;
  private String type;
  private String text;
  private List<File> files;
  private List<String> filesContentType;
  private List<String> filesFileName;
  private String destPath;
  private int productId;
  private String cover="";
  private HttpServletRequest servletRequest;
  private PictureService pictureService;


  public ProductAction(){
    ApplicationContext context = InitApplicationContext.getApplicationContext();
    productService =(ProductService) context.getBean("productService");
    pictureService = (PictureService) context.getBean("pictureService");
  }

  public List<Picture> getPictureList() {
    return pictureList;
  }

  public void setPictureList(List<Picture> pictureList) {
    this.pictureList = pictureList;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public List<File> getFiles() {
    return files;
  }

  public void setFiles(List<File> files) {
    this.files = files;
  }

  public List<String> getFilesContentType() {
    return filesContentType;
  }

  public void setFilesContentType(List<String> filesContentType) {
    this.filesContentType = filesContentType;
  }

  public List<String> getFilesFileName() {
    return filesFileName;
  }

  public void setFilesFileName(List<String> filesFileName) {
    this.filesFileName = filesFileName;
  }

  public String getDestPath() {
    return destPath;
  }

  public void setDestPath(String destPath) {
    this.destPath = destPath;
  }


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ProductService getProductService() {
    return productService;
  }

  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public String execute() throws Exception {
    System.out.println(product);
    if(product != null){
      System.out.println(product.getName());
    }
    message = "成功添加!";
    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    if(product.getId()!=0){
      productService.updatePoduct(product);
    }else{
      productService.addProduct(product);
    }
    System.out.println("after new add product id==: "+product.getId());
    if(files!=null){
      saveImage(product.getId(), user);
      product.setCover(cover);
      productService.updatePoduct(product);
    }
    productList = productService.findByOwner(user.getId());
    return "listProduct";
  }


  public String edit(){
    System.out.println("edit: "+productId);
    product = productService.findById(productId).get(0);
    pictureList = pictureService.listPictureByProduct(productId);
    return "modify";
  }

  public String delete(){
    System.out.println("delete: "+ productId);
    product = new Product();
    product.setId(productId);
    productService.deletePoduct(product);
    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }
    productList = productService.findByOwner(user.getId());
    return "listProduct";
  }
  private void saveImage(int productId,User user) {
    HttpSession session = servletRequest.getSession();
    ServletContext context = session.getServletContext();
    String filePath = context.getRealPath("/")+"images\\";
    RandomStringUtils randomStringUtils= new RandomStringUtils();
    Picture picture;
    for (int i = 0; i < files.size(); i++) {
      File uploadedFile = files.get(i);
      String fileName = filesFileName.get(i);
      String saveName = randomStringUtils.random(5, true, true)+"."+fileName.split("\\.")[1];
      File destFile = new File(filePath, saveName);
      System.out.println("save name"+saveName);
      try {
        FileUtils.copyFile(uploadedFile, destFile);

      } catch (IOException ex) {
        System.out.println("Could not copy file " + fileName);
        ex.printStackTrace();
      }

      picture = new Picture();
      picture.setCreatedAt(new Date());
      picture.setProductId(productId);
      picture.setDir(saveName);
      picture.setOwner(user.getId());
      pictureService.addPicture(picture);
      if(i==0){
        cover = saveName;
      }
    }
  }

  public String listMy(){
    System.out.println("try get my products");

    User user = (User) ActionContext.getContext().getSession().get("user");
    if(user == null){
      return "error";
    }

    productList = productService.findByOwner(user.getId());

    return "listProduct";
  }
  public String listAll(){
    System.out.println("try get all products");

    productList = productService.findAll();

    return "listProduct";
  }

  public String listByType(){

    System.out.println(type);
    productList = productService.findByType(type);

    return "listProductByType";
  }

  public String searchByText(){
    System.out.println("search"+ text);
    productList = productService.findByText(text);
    return "listProductByType";
  }

  public void setServletRequest(HttpServletRequest httpServletRequest) {
    this.servletRequest = httpServletRequest;
  }
}
