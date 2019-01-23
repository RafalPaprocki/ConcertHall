import { Injectable, OnInit } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from './auth/token-storage.service';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, OnInit{


    private roles: string[];
    private authority: string;
    private isLoggedIn = false;
    private username;
  constructor( private token: TokenStorageService, private tokenStorage: TokenStorageService) {}

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
        this.username = this.token.getUsername();
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }
  canActivate(): Observable<boolean> | Promise<boolean> | boolean {
    if (this.authority = 'admin' ) {
      return true;
    }
    return false;
  }
}
