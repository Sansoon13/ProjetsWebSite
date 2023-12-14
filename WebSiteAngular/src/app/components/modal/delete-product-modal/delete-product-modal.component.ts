import { Component, Inject, Injectable, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ProductComponent } from '../../products/product/product.component';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-delete-product-modal',
  templateUrl: './delete-product-modal.component.html',
  styleUrls: ['./delete-product-modal.component.css']
})

@Injectable({
  providedIn:'root'
})

export class DeleteProductModalComponent implements OnInit{
  nom!:string;

  constructor(private dialogRef:MatDialogRef<DeleteProductModalComponent>,private t:ProductComponent,
    @Inject(MAT_DIALOG_DATA) public data:any , private router:Router,private proSrv:ProductService){}


  ngOnInit(): void {
    this.proSrv.getById(this.data.id).subscribe(r=>{
      this.nom=r.title+"";
    })
  }

  delete(){
    this.dialogRef.close();
    console.log('confirmation')
    this.t.deleteProduct(this.data.id);
    this.openDialog();
    
  }

  openDialog(){
    
  }
}
