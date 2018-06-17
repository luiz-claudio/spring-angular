import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Options } from 'selenium-webdriver/edge';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()

export class ListaServiceService {
  private baseApiPath="http://localhost:9000/api";
  private token= window.localStorage.getItem('token');
  private httpOptions = {
    headers: new HttpHeaders({
    'Accept':  'application/json',
    'Authorization': `Bearer  `

   })
};



  constructor(public http: HttpClient, private router:Router) {

    this.token = window.localStorage.getItem('token');
    if(this.token ==null){
    //  router.navigate(['/login']);
    }
   }


   setToken (valor){
     this.token = (valor);
   }

    excluir(id){
      return this.http.delete(`${this.baseApiPath}/cadastro/${id}`,this.httpOptions);
    }

    cadastrar(dados){
      return this.http.post(`${this.baseApiPath}/cadastro/`,dados);
    }

    show(id){
      return this.http.get(`${this.baseApiPath}/cadastro/${id}`,this.httpOptions);
    }

    update(id,dados){
      return this.http.put(`${this.baseApiPath}/cadastro/${id}`,dados);
    }

    getToken(dados)
    {
   //   return this.http.post(`${this.baseApiPath}/login`,dados);
    }




}
