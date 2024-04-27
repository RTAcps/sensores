import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('#onResize', () => {
    it('should set isMobileView to true if window.innerWidth <= 768', () => {
      // Arrange
      spyOnProperty(window, 'innerWidth', 'get').and.returnValue(768);
      const mockEvent = { target: { innerWidth: 768 } };
      // Act
      component.onResize(mockEvent);
      // Assert
      expect(component.isMobileView).toBeTruthy();
    });

    it('should set isMobileView to false if window.innerWidth > 768', () => {
      // Arrange
      const mockEvent = { target: { innerWidth: 769 } };
      // Act
      component.onResize(mockEvent);
      // Assert
      expect(component.isMobileView).toBeFalsy();
    });
  });
});
