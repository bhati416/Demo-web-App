import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Headers, RequestOptions } from '@angular/http';
import { HttpInterceptorService, RESTService } from '@covalent/http';
import { MOCK_API } from '../config/api.config';

export interface IUser {
  displayName: string;
  id: string;
  email: string;
  created: Date;
  lastAccess: Date;
  siteAdmin: number;
  
}

@Injectable()
export class UsersService extends RESTService<IUser> {

public handleError: any;
  public extractData: any;
 protected options: RequestOptions;
  constructor(private _http: HttpInterceptorService) {
    super(_http, {
      baseUrl: MOCK_API,
      path: '/users',
    });

        this.handleError = this.getHandleErrorFunction();
        this.extractData = this.getExtractDataFunction();
  }
  /*public doGet(url: String){
    //console.log('In doGet');
        return this._http.get(this.baseUrl + url)
            .map(this.extractData);
    }*/
    
  getAllUser(){
  return this._http.get('http://localhost:8080/user')
  .map((res: Response) => {
  return res.json();
  });
}
  deleteUser(id:string){
    alert('id no: '+id+' is deleted');
    this.setRequestOptions();
    return this._http.delete('http://localhost:8080/user/'+id, this.options)
            .map(this.extractText)
            .catch(this.handleError);
   // return this._http.delete('http://localhost:8080/user/'+id);
  }
/*addUser(data:any){
    //alert('id no: '+id+' is deleted');
    
    this.setRequestOptions();
    alert('inside service');
    //var json = JSON.stringify({"id":'',"name":n,"email":e});
    var params='json='+data;   
    console.log('data:'+params);
     return this._http.post('http://localhost:8080/user',params,this.option)
            .map(this.extractText)
            .catch(this.handleError);

     }*/
    public doPost(data: any){
        this.setRequestOptions();
        let bodyString = data;
        return this._http.post('http://localhost:8080/user', bodyString, this.options)
            .map(this.extractText)
            .catch(this.handleError);
    }
    public doUpdate(id:string,data:any)
    {
        this.setRequestOptions();
        let bodyString = data;
        return this._http.put('http://localhost:8080/user/'+id, bodyString, this.options)
            .map(this.extractText)
            .catch(this.handleError);
    }   
  
getExtractDataFunction() {
      return function(res: Response) {
          if(res.status == 204){
              return res.text().toString();
          } else {
              return res.json();
          }
      }
    }
setRequestOptions(){
       
            let headers = new Headers({ 'Content-Type': 'application/json' });
            this.options = new RequestOptions({ headers: headers });
        
    }

 extractText (res: Response) {
        let body = res.text();
        return body || res.toString();
    }
    public setAuthenticationToken(){
        let token =  sessionStorage.getItem("token");
        if(token){
            let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': token });
            this.options = new RequestOptions({ headers: headers });
        }else{
            let headers = new Headers({ 'Content-Type': 'application/json' });
            this.options = new RequestOptions({ headers: headers });
        }
    }

  getHandleErrorFunction() {
    let _self = this;
    return function(error: any){
        var message;
        try{
          var body = JSON.parse(error._body);
          message = body.error;
        }
        catch(e){
          message = error._body
        }

        error.statusText = message;
        error.message = message;
        return Observable.throw(error);
      }
  }
}
