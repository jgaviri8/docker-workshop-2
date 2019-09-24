import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

constructor(
    private httpClient: HttpClient
  ) { }

  createProduct(data) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Accept': 'application/json'
      })
    };
      this.httpClient.post('http://localhost:8080/jgaviri8/ProductsAPI/1.0.0/product', data, httpOptions).subscribe(product => {
      console.log('Product created', product);
    });
  }

  searchProduct(data) {
    console.log('buscando', data);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Accept': 'application/json'
      }),
      params: new HttpParams().set('name', data.name)
    };
    console.log('opciones', httpOptions);
    return this.httpClient.get('http://localhost:8080/jgaviri8/ProductsAPI/1.0.0/product/findByName', httpOptions);
  }
}
