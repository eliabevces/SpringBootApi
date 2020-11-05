# umctec Back end code challenge
 The challenge is to build a api to post and get activities, to post cards and get cards with some additional information
 
## Project structure
- [models](https://github.com/eliabevces/SpringBootApi/tree/main/src/main/java/com/example/demo/model "model")
	- [card](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/model/card.java "card.java")
	- [Activity](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/model/Activity.java "Activity.java")
	- [Bill](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/model/Bill.java "Bill.java")
	- [Health Insurance.](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/model/HealthInsurance.java "HealthInsurance.java")
	- [Patient](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/model/Patient.java "Patient.java")
	- [Card Data](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/model/CardData.java "CardData.java") 

- [Repositories](https://github.com/eliabevces/SpringBootApi/tree/main/src/main/java/com/example/demo/repo "repo")
	- [Activityrepo](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/repo/Activityrepo.java "Activityrepo.java")
	- [Cardrepo](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/repo/Cardrepo.java "Cardrepo.java")
	- [HealthInsurancerepo](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/repo/HealthInsurancerepo.java "HealthInsurancerepo.java")
	- [Patientrepo](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/repo/Patientrepo.java "Patientrepo.java")
	- [Billrepo](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/repo/Billrepo.java "Billrepo.java")

- [Rest Controllers](https://github.com/eliabevces/SpringBootApi/tree/main/src/main/java/com/example/demo/controller "controller")
	- [Card Controller](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/controller/CardController.java "CardController.java")
	- [Activity Controller](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/controller/ActivityController.java "ActivityController.java")
	- [Bill Controller](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/controller/BillController.java "BillController.java")
	- [Health Insurance Controller](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/controller/HealthInsuranceController.java "HealthInsuranceController.java")
	- [Patient Controller](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/controller/PatientController.java "PatientController.java")

- [database example](https://github.com/eliabevces/SpringBootApi/tree/main/src/main/java/com/example/demo/database "database")
	- [Database Loader](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/database/LoadDatabase.java "LoadDatabase.java")

- [Spring Boot Api Application](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/SpringBootApiApplication.java "SpringBootApiApplication.java")

## Instructions to build and run the project
- I recommend to use:
	- [Spring Boot Tool suite 4](https://github.com/eliabevces/SpringBootApi/blob/main/src/main/java/com/example/demo/SpringBootApiApplication.java "Spring Boot Tool suite 4")
	- [Postman](https://www.postman.com/downloads "Postman")
- Create a Spring Starter Project on Spring Boot Tool suite 4 and clone all the structures to theirs respective locations.
- Run SpringBootApiApplication.java as a Spring Boot App
- Open Postman to run the endpoints bellow

### Main endpoints
- Get all activity (GET) : http://localhost:8080/activities
	- Example Database returns:
		
``` json
[

[

{

"activityid":  10,

"activityTitle":  "Berçario",

"activitysubtitle":  "Organizar Prontuario",

"sla":  10,

"cards":  [

{

"visitId":  15,

"checklist":  {

"check 4":  false,

"check 2":  true,

"check 3":  true,

"check 1":  true

},

"documents":  {

"document 1":  true,

"document 2":  false,

"document 3":  true,

"document 4":  false

},

"pendencies":  {

"pendency 1":  false,

"pendency 2":  false,

"pendency 3":  false,

"pendency 4":  false

},

"createdIn":  "2020-11-05"

}

]

},

{

"activityid":  11,

"activityTitle":  "Auditoria",

"activitysubtitle":  "Limpar Conta",

"sla":  20,

"cards":  [

{

"visitId":  14,

"checklist":  {

"check 4":  true,

"check 2":  true,

"check 3":  true,

"check 1":  true

},

"documents":  {

"document 1":  true,

"document 2":  true,

"document 3":  true,

"document 4":  true

},

"pendencies":  {

"pendency 1":  false,

"pendency 2":  true,

"pendency 3":  true,

"pendency 4":  false

},

"createdIn":  "2020-11-05"

}

]

},

{

"activityid":  12,

"activityTitle":  "Centro Cirurgico",

"activitysubtitle":  "organizar Prontuario",

"sla":  2,

"cards":  [

{

"visitId":  13,

"checklist":  {

"check 4":  false,

"check 2":  false,

"check 3":  false,

"check 1":  false

},

"documents":  {

"document 1":  false,

"document 2":  false,

"document 3":  false,

"document 4":  false

},

"pendencies":  {

"pendency 1":  true,

"pendency 2":  true,

"pendency 3":  true,

"pendency 4":  true

},

"createdIn":  "2020-11-05"

}

]
```

- Create Activity (POST): http://localhost:8080/activities/createactivity({activityTitle},{activitySubtitle},{sla})
	- Example: http://localhost:8080/activities/createactivity(Atividade1,subtitulo_da_atividade,15)
	- Example Database returns after get:
``` json
{

"activityid":  16,

"activityTitle":  "Atividade1",

"activitysubtitle":  "subtitulo_da_atividade",

"sla":  15,

"cards":  []

}
```

- Get all cards (GET) : http://localhost:8080/cards
	-  Example Database returns:

``` json
{

"_embedded":  {

"Cards":  [

{

"checklist":  {

"check 4":  false,

"check 2":  false,

"check 3":  false,

"check 1":  false

},

"documents":  {

"document 1":  false,

"document 2":  false,

"document 3":  false,

"document 4":  false

},

"pendencies":  {

"pendency 1":  true,

"pendency 2":  true,

"pendency 3":  true,

"pendency 4":  true

},

"createdIn":  "2020-11-05",

"_links":  {

"self":  {

"href":  "http://localhost:8080/cards/13"

},

"card":  {

"href":  "http://localhost:8080/cards/13"

},

"healthinsurance":  {

"href":  "http://localhost:8080/cards/13/healthinsurance"

},

"bill":  {

"href":  "http://localhost:8080/cards/13/bill"

},

"patient":  {

"href":  "http://localhost:8080/cards/13/patient"

},

"activity":  {

"href":  "http://localhost:8080/cards/13/activity"

}

}

},

{

"checklist":  {

"check 4":  true,

"check 2":  true,

"check 3":  true,

"check 1":  true

},

"documents":  {

"document 1":  true,

"document 2":  true,

"document 3":  true,

"document 4":  true

},

"pendencies":  {

"pendency 1":  false,

"pendency 2":  true,

"pendency 3":  true,

"pendency 4":  false

},

"createdIn":  "2020-11-05",

"_links":  {

"self":  {

"href":  "http://localhost:8080/cards/14"

},

"card":  {

"href":  "http://localhost:8080/cards/14"

},

"healthinsurance":  {

"href":  "http://localhost:8080/cards/14/healthinsurance"

},

"bill":  {

"href":  "http://localhost:8080/cards/14/bill"

},

"patient":  {

"href":  "http://localhost:8080/cards/14/patient"

},

"activity":  {

"href":  "http://localhost:8080/cards/14/activity"

}

}

},

{

"checklist":  {

"check 4":  false,

"check 2":  true,

"check 3":  true,

"check 1":  true

},

"documents":  {

"document 1":  true,

"document 2":  false,

"document 3":  true,

"document 4":  false

},

"pendencies":  {

"pendency 1":  false,

"pendency 2":  false,

"pendency 3":  false,

"pendency 4":  false

},

"createdIn":  "2020-11-05",

"_links":  {

"self":  {

"href":  "http://localhost:8080/cards/15"

},

"card":  {

"href":  "http://localhost:8080/cards/15"

},

"healthinsurance":  {

"href":  "http://localhost:8080/cards/15/healthinsurance"

},

"bill":  {

"href":  "http://localhost:8080/cards/15/bill"

},

"patient":  {

"href":  "http://localhost:8080/cards/15/patient"

},

"activity":  {

"href":  "http://localhost:8080/cards/15/activity"

}

}

}

]

},

"_links":  {

"self":  {

"href":  "http://localhost:8080/cards"

},

"profile":  {

"href":  "http://localhost:8080/profile/cards"

}

},

"page":  {

"size":  20,

"totalElements":  3,

"totalPages":  1,

"number":  0

}

}
```

- Get especific Cards (GET) : http://localhost:8080/cards/searchcards({activityid},{q},{qvalue},{filter},{page},{perpage})
	-  Example: http://localhost:8080/cards/searchcards(11,patientName,Patient1,TO_RECEIVE,2,1)
	- Example returns:
``` json
[

{

"card 15":  {

"daysSinceCreated":  0,

"slaStatus":  "OK",

"patientid":  1,

"patientname":  "Patient1",

"healthInsuranceid":  4,

"healthInsuranceName":  "Unimed",

"visitId":  15,

"billid":  9,

"billtype":  "Hospitalar",

"totalAmount":  50000.0,

"numberOfPendencies":  4,

"numberOfOpenPendencies":  4,

"numberOfDocuments":  4,

"numberOfNotReceivedDocuments":  2,

"numberOfChecklistItem":  4,

"numberOfDoneChecklistItem":  3

}

},

{

"totalCardsOk":  1

},

{

"totalCardsWarning":  0

},

{

"totalCardsDelayed":  0

},

{

"Cards per page":  1,

"Page":  2

}

]
```
- Create Card (POST): http://localhost:8080/cards/createcard({patientId},{healthinsuranceid},{billtype},{billtotalamount},{activityid})
	- Example: http://localhost:8080/cards/createcard(3,5,Ambulatorial,999.50,12)
	- GET  card by visit id after POST example returns:

```json
[

{

"card 17":  {

"daysSinceCreated":  0,

"slaStatus":  "OK",

"patientid":  3,

"patientname":  "PatientThree",

"healthInsuranceid":  5,

"healthInsuranceName":  "porto seguro",

"visitId":  17,

"billid":  16,

"billtype":  "Ambulatorial",

"totalAmount":  999.5,

"numberOfPendencies":  0,

"numberOfOpenPendencies":  0,

"numberOfDocuments":  0,

"numberOfNotReceivedDocuments":  0,

"numberOfChecklistItem":  0,

"numberOfDoneChecklistItem":  0

}

},

{

"totalCardsOk":  1

},

{

"totalCardsWarning":  0

},

{

"totalCardsDelayed":  0

},

{

"Cards per page":  10,

"Page":  1

}

]
```

### Other endpoints
- Add Check item to Card (POST) : http://localhost:8080/cards/addcheckitem({cardid},{description},{done})

- Add document to Card (Post): http://localhost:8080/cards/adddocument({cardid},{description},{received})

- Add pendency to Card (POST): http://localhost:8080/cards/addpendency({cardid},{description},{done})

- Get all Bills (GET): http://localhost:8080/bills

- Get all Patients (GET): http://localhost:8080/patients

- Get all Health Insurances (GET): http://localhost:8080/healthinsurances

