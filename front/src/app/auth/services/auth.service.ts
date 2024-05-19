import { Injectable, Signal, computed, isDevMode } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { lastValueFrom } from "rxjs";
import { Router } from "@angular/router";
import AccessToken from "../types/AccessToken.type";
import jwt, { jwtDecode } from "jwt-decode";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private accessToken: string = "";
  public isLoggedIn: Signal<boolean> = computed(() => {
    if (this.accessToken !== "") return true;
    return false;
  });

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {
    const localToken = window.localStorage.getItem("access_token") || "";
    if (this.isTokenValid(localToken)) {
      this.accessToken = localToken;
    }
  }

  async login(username: string, password: string): Promise<string> {
    try {
      const response = await lastValueFrom(this.http.post<{ accessToken: string }>("auth/login", { username, password }));

      if (this.isTokenValid(response.accessToken)) {
        window.localStorage.setItem("access_token", this.accessToken);
        this.accessToken = response.accessToken;
        return "OK";
      } else {
        this.logout();
        return "Incorrect JWT";
      }
    } catch (error : any) {
      console.error("HTTP Error:", error);
      return String(error.message);
    }
  }

  logout() {
    window.localStorage.removeItem("access_token");
    this.accessToken = "";
    this.router.navigate(["/login"]);
  }

  async register(email: string, password: string) {
    const response = await lastValueFrom(this.http.post<{ accessToken: string }>("auth/register", { email, password }));
  }

  getAccessToken(): string {
    if (this.accessToken) {
      return this.accessToken;
    }
    throw new Error("User is not logged in");
  }

  private isTokenValid(accessToken: string): boolean {
    const currentTimestamp = Math.floor(Date.now() / 1000);
    if (accessToken.trim() === "") {
      console.info("No access token in the local storage");
      return false;
    }

    try {
      const decodedToken = jwtDecode(accessToken) as AccessToken;
      if (decodedToken.exp < currentTimestamp) {
        return false;
      }
      return true;
    } catch (error) {
      isDevMode() && console.error("Failed to decode JWT");
      return false;
    }
  }
}
