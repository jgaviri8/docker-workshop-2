import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  createProductForm;
  searchProductForm;
  products;

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit() {
    this.createProductForm = this.formBuilder.group({
      name: '',
      description: '',
      price: 0.0
    });
    this.searchProductForm = this.formBuilder.group({
      name: ''
    });
  }

  onCreateProductFormSubmit(data) {
    this.productService.createProduct(data);
  }

  onSearchProductFormSubmit(data) {
    this.products = [];
    this.productService.searchProduct(data).subscribe(products=>this.products = products);
  }

}
