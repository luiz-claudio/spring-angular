import { Component, OnInit } from '@angular/core';
import { ListaServiceService } from '../lista-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-agenda-form',
  templateUrl: './agenda-form.component.html',
  styleUrls: ['./agenda-form.component.css']
})
export class AgendaFormComponent implements OnInit {

  cadastro= {
    nome:'',
    email:'',
    login:'',
    senha:'',
  }

  constructor(private cadastroHttp: ListaServiceService, private route: ActivatedRoute) {


   }


  ngOnInit() { }
  

  store(){
    this.cadastroHttp.cadastrar(this.cadastro).subscribe(
      data=>{
        const response                       = (data as any);
        console.log(response);
          alert('cadastrado');
    }, error=>{
      console.log(error);
     })

  }






}
