import { Component, effect, ElementRef, HostListener, ViewChild } from "@angular/core";
import { User } from "../../../../shared/types/User.type";
import { MatDialogClose } from "@angular/material/dialog";
import { SearchUserService } from "../../services/search-user/search-user.service";

@Component({
  selector: "app-search-user-popup",
  standalone: true,
  imports: [MatDialogClose],
  templateUrl: "./search-user-popup.component.html",
  styleUrl: "./search-user-popup.component.css",
})
export class SearchUserPopupComponent {
  users: User[] = [];
  @ViewChild("search") searchInput!: ElementRef;

  constructor(private searchUserService: SearchUserService) {
    effect(() => {
      this.users = this.searchUserService.searchResults();
    });
  }

  ngAfterViewInit(): void {
    this.searchInput.nativeElement.focus();
  }

  public searchUser(query: string) {
    if (query.trim() === "") {
      this.users = [];
      return;
    }

    this.searchUserService.search(query);
  }
}
