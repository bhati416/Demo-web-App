import {Injectable} from "angular2/core";
import {Http} from "angular2/core";
@Injectable()
export class HTTPTestService{
	constructor(private _http:Http){}
	
	getAllUser()
	{
		return this._http.get('http://localhost:8080/user').map(res => res.json);
	}
}