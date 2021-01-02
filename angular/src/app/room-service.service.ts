import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8080/api/v1/room';

  constructor(private http: HttpClient) { }

  getRoom(roomId: number): Observable<any>{
    return this.http.get(`${this.baseUrl}/${roomId}`);
  }
  getRoomList():Observable<any>{
    return this.http.get(`${this.baseUrl}s`)
  }
  createRoom(room:Object):Observable<Object>{
    return this.http.post(`${this.baseUrl}`,room);
  }
  updateRoom(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteRoom(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}