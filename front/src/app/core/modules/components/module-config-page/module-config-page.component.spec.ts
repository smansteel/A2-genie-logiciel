import { ComponentFixture, TestBed } from "@angular/core/testing";

import { ModuleConfigPageComponent } from "./module-config-page.component";

describe("ModulePageComponent", () => {
  let component: ModuleConfigPageComponent;
  let fixture: ComponentFixture<ModuleConfigPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModuleConfigPageComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ModuleConfigPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
