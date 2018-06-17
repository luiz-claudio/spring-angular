import { Component, OnInit } from '@angular/core';
import { ListaServiceService } from '../lista-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario={
    login:'',
    senha:'',
  }

  constructor(private agendaHttp:ListaServiceService, private router:Router) { }

  ngOnInit() {
  }

  login()
  {

    this.router.navigate(['/agenda']);
    /*
    this.agendaHttp.getToken(this.usuario).subscribe(
      data=>{
        const response     = (data as any);
        console.log(response);
        window.localStorage.setItem('token',response.token);
        location.reload();
        this.router.navigate(['/agenda']);


      }, error=>{
        console.log(error);
        alert('Usuário ou senha inválidos')
      })
 */
    }

    cadastro(){
      this.router.navigate(['/agenda/form']);
    }



}
