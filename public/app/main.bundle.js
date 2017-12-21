webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".content {\n  padding: 10px;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-toolbar color=\"primary\">\n  <mat-toolbar-row>\n    <span>Service Builder</span>\n  </mat-toolbar-row>\n</mat-toolbar>\n\n\n<mat-sidenav-container>\n  <mat-sidenav mode=\"side\" opened=\"true\">\n    <mat-list>\n      <mat-list-item>Movies</mat-list-item>\n    </mat-list>\n  </mat-sidenav>\n  <mat-sidenav-content class=\"content\">\n\n    <app-svc-entity>\n    </app-svc-entity>\n  </mat-sidenav-content>\n</mat-sidenav-container>\n\n\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AppComponent = (function () {
    function AppComponent() {
    }
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Input */])(),
        __metadata("design:type", String)
    ], AppComponent.prototype, "name", void 0);
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material_toolbar__ = __webpack_require__("../../../material/esm5/toolbar.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_material_card__ = __webpack_require__("../../../material/esm5/card.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_material_button__ = __webpack_require__("../../../material/esm5/button.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_material_list__ = __webpack_require__("../../../material/esm5/list.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_material_input__ = __webpack_require__("../../../material/esm5/input.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_material_form_field__ = __webpack_require__("../../../material/esm5/form-field.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__angular_material_select__ = __webpack_require__("../../../material/esm5/select.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__angular_material_icon__ = __webpack_require__("../../../material/esm5/icon.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__angular_material_sidenav__ = __webpack_require__("../../../material/esm5/sidenav.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__angular_material_snack_bar__ = __webpack_require__("../../../material/esm5/snack-bar.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_16__svc_entity_svc_entity_component__ = __webpack_require__("../../../../../src/app/svc-entity/svc-entity.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_17__svc_property_svc_property_component__ = __webpack_require__("../../../../../src/app/svc-property/svc-property.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



 // <-- #1 import module














var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["H" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_15__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_16__svc_entity_svc_entity_component__["a" /* SvcEntityComponent */],
                __WEBPACK_IMPORTED_MODULE_17__svc_property_svc_property_component__["a" /* SvcPropertyComponent */],
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_material_toolbar__["a" /* MatToolbarModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_material_card__["a" /* MatCardModule */],
                __WEBPACK_IMPORTED_MODULE_6__angular_material_button__["a" /* MatButtonModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_material_list__["a" /* MatListModule */],
                __WEBPACK_IMPORTED_MODULE_8__angular_material_input__["b" /* MatInputModule */],
                __WEBPACK_IMPORTED_MODULE_9__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_material_form_field__["c" /* MatFormFieldModule */],
                __WEBPACK_IMPORTED_MODULE_11__angular_material_select__["a" /* MatSelectModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["i" /* ReactiveFormsModule */],
                __WEBPACK_IMPORTED_MODULE_12__angular_material_icon__["a" /* MatIconModule */],
                __WEBPACK_IMPORTED_MODULE_13__angular_material_sidenav__["a" /* MatSidenavModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_14__angular_material_snack_bar__["b" /* MatSnackBarModule */]
            ],
            providers: [],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_15__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/model/Svc.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return Type; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return SvcProperty; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SvcEntity; });
/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
var Type;
(function (Type) {
    Type["String"] = "string";
    Type["Integer"] = "integer";
    Type["Float"] = "Float";
})(Type || (Type = {}));
var SvcProperty = (function () {
    function SvcProperty() {
    }
    return SvcProperty;
}());

var SvcEntity = (function () {
    function SvcEntity() {
        this.properties = [];
    }
    return SvcEntity;
}());



/***/ }),

/***/ "../../../../../src/app/svc-entity/svc-entity.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/svc-entity/svc-entity.component.html":
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"example-card\">\n  <mat-card-header>\n    <mat-card-title>Movies</mat-card-title>\n    <mat-card-subtitle>Version {{1}}</mat-card-subtitle>\n\n\n  </mat-card-header>\n  <mat-card-content>\n    <mat-list>\n      <mat-list-item *ngFor=\"let property of entity.properties;\n                             let idx = index\">\n        <div>\n          <app-svc-property [property]=\"property\"\n                            [formGroup]=\"propertyArray.controls[idx]\">\n          </app-svc-property>\n        </div>\n      </mat-list-item>\n    </mat-list>\n    <button mat-mini-fab\n            (click)=\"onAdd()\">\n      <mat-icon>add</mat-icon>\n    </button>\n  </mat-card-content>\n  <mat-card-actions>\n    <button mat-button\n            (click)=\"onSave()\">Save\n    </button>\n  </mat-card-actions>\n</mat-card>\n"

/***/ }),

/***/ "../../../../../src/app/svc-entity/svc-entity.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SvcEntityComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__model_Svc__ = __webpack_require__("../../../../../src/app/model/Svc.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_material__ = __webpack_require__("../../../material/esm5/material.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SvcEntityComponent = (function () {
    function SvcEntityComponent(snackBar, http, formBuilder) {
        this.snackBar = snackBar;
        this.http = http;
        this.formBuilder = formBuilder;
        this.entity = new __WEBPACK_IMPORTED_MODULE_1__model_Svc__["a" /* SvcEntity */]();
        this.propertyArray = this.formBuilder.array([]);
    }
    SvcEntityComponent.prototype.ngOnInit = function () {
        this.entity.name = "movies";
        this.entityGroup = this.formBuilder.group({
            properties: this.propertyArray
        });
        if (this.entity.properties.length == 0) {
            this.appendProperty();
        }
    };
    SvcEntityComponent.prototype.appendProperty = function () {
        this.propertyArray.push(this.formBuilder.group({
            name: ['', __WEBPACK_IMPORTED_MODULE_4__angular_forms__["j" /* Validators */].required],
            dataType: ['', __WEBPACK_IMPORTED_MODULE_4__angular_forms__["j" /* Validators */].required]
        }));
        this.entity.properties.push(new __WEBPACK_IMPORTED_MODULE_1__model_Svc__["b" /* SvcProperty */]());
    };
    SvcEntityComponent.prototype.onAdd = function () {
        this.appendProperty();
    };
    SvcEntityComponent.prototype.onSave = function () {
        this.http.post('/api/SvcEntity', this.entity).subscribe(function (data) {
            // Read the result field from the JSON response.
        });
        /*    if (this.entityGroup.invalid) {
              this.snackBar.open("Looks Like There's An Error!", 'Dismiss');
            } else {
            }
            console.log("Save Pressed");*/
    };
    SvcEntityComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'app-svc-entity',
            template: __webpack_require__("../../../../../src/app/svc-entity/svc-entity.component.html"),
            styles: [__webpack_require__("../../../../../src/app/svc-entity/svc-entity.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__angular_material__["a" /* MatSnackBar */],
            __WEBPACK_IMPORTED_MODULE_2__angular_common_http__["a" /* HttpClient */],
            __WEBPACK_IMPORTED_MODULE_4__angular_forms__["b" /* FormBuilder */]])
    ], SvcEntityComponent);
    return SvcEntityComponent;
}());



/***/ }),

/***/ "../../../../../src/app/svc-property/svc-property.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/svc-property/svc-property.component.html":
/***/ (function(module, exports) {

module.exports = "<form [formGroup]=\"formGroup\">\n  <mat-form-field>\n    <input matInput\n           [(ngModel)]=\"property.name\"\n           placeholder=\"Property Name\"\n           formControlName=\"name\">\n  </mat-form-field>\n  <mat-form-field>\n    <mat-select [(value)]=\"property.dataType\"\n                placeholder=\"Data Type\"\n                formControlName=\"dataType\">\n      <mat-option\n        *ngFor=\"let propType of propTypes\"\n        [value]=\"propType.value\">\n        {{propType.viewValue}}\n      </mat-option>\n    </mat-select>\n  </mat-form-field>\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/svc-property/svc-property.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SvcPropertyComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__model_Svc__ = __webpack_require__("../../../../../src/app/model/Svc.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var SvcPropertyComponent = (function () {
    function SvcPropertyComponent() {
        this.propTypes = [
            { value: __WEBPACK_IMPORTED_MODULE_1__model_Svc__["c" /* Type */].Integer, viewValue: "Integer" },
            { value: __WEBPACK_IMPORTED_MODULE_1__model_Svc__["c" /* Type */].Float, viewValue: "Float" },
            { value: __WEBPACK_IMPORTED_MODULE_1__model_Svc__["c" /* Type */].String, viewValue: "String" }
        ];
    }
    SvcPropertyComponent.prototype.ngOnInit = function () {
        // this.formGroup = this.formBuilder.group({
        //   name: ['', Validators.required],
        //   dataType: ['', Validators.required]
        // });
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Input */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_1__model_Svc__["b" /* SvcProperty */])
    ], SvcPropertyComponent.prototype, "property", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Input */])(),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormGroup */])
    ], SvcPropertyComponent.prototype, "formGroup", void 0);
    SvcPropertyComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["m" /* Component */])({
            selector: 'app-svc-property',
            template: __webpack_require__("../../../../../src/app/svc-property/svc-property.component.html"),
            styles: [__webpack_require__("../../../../../src/app/svc-property/svc-property.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], SvcPropertyComponent);
    return SvcPropertyComponent;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_12" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map