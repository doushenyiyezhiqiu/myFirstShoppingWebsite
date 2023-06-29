import { TestBed } from '@angular/core/testing';

import { MyShoppingWebsiteFormService } from './my-shopping-website-form-service.service';

describe('MyShoppingWebsiteFormService', () => {
  let service: MyShoppingWebsiteFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyShoppingWebsiteFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
