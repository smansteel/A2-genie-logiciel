import { Injectable, signal, WritableSignal } from "@angular/core";
import { User } from "../../../../shared/types/User.type";
import { catchError, from, map, of } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { UserService } from "../../../../shared/services/user/user.service";

@Injectable({
  providedIn: "root",
})
export class SearchUserService {
  public searchResults: WritableSignal<User[]> = signal([]);

  constructor(
    private http: HttpClient,
    private userService: UserService,
  ) {}

  async search(query: string) {
    const searchTerm = query.toLowerCase();

    //from(this.http.get<User[]>("users/"))
    from(this.userService.getFakeUserList())
      .pipe(
        map(data => data as User[]),
        map(users =>
          users.filter(user => user.firstName.toLowerCase().includes(searchTerm) || user.name.toLowerCase().includes(searchTerm)),
        ),
        catchError(error => {
          console.error(error);
          return of([]);
        }),
      )
      .subscribe(filteredUsers => this.searchResults.set(filteredUsers));
  }
}
