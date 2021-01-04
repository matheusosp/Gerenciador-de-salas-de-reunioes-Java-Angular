import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Room } from '../room';
import { RoomService } from '../room-service.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms!: Room[];
  loader: boolean = false;

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
    console.log(this.loader);
  }
  reloadData() {
    this.roomService.getRoomList().subscribe(
      (data) => {
        this.rooms = data;
        this.loader = true;
        console.log(this.loader);
      }
    );
  }

  deleteRoom(id: number) {
    this.roomService.deleteRoom(id)
      .subscribe(
        () => {
          this.reloadData();
        },
        error => console.log(error));
  }

  roomDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number){
    this.router.navigate(['update', id]);
  }
}
