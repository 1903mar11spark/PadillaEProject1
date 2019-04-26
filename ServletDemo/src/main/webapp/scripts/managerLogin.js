let user = {};

window.onload = function() {
	//document.getElementById("allReim").addEventListener('click',fetchAllReim);
	document.getElementById("viewEmployees").addEventListener('click',fetchViewEmployees);
	//document.getElementById("approvedReim").addEventListener('click',fetchApprovedReim);
	populateUser();
}
//
////function fetchAllReim() {
//	//send GET request to SessionServlet to obtain session information
//	fetch("http://localhost:8084/ServletDemo/ViewReim", {method:"GET", headers:{"Accept":"application/json"}})
//	.then(function(response) {
//		return response.json();
//	}).then(function(data) {
//		//check whether there was a valid session
//		console.log(data);
//		while (RowForBody.firstChild){
//			RowForBody.removeChild(RowForBody.firstChild);
//		}
//		
//		for(let i=0; i<data.reimbursements.length;i++){
//				let row = document.createElement("tr");
//		        row.id="row" + i;
//		        row.class=row;
//		        document.getElementById("RowForBody").appendChild(row);
//		    	
//		        let rid = document.createElement("td");
//		        rid.className="rid";
//		        rid.innerHTML=data.reimbursements[i].reimId;
//		        document.getElementById("row"+i).appendChild(rid);
//		        
//		    
//		    	let manId = document.createElement("td");
//		    	manId.className = "manId";
//		    	manId.innerHTML = data.reimbursements[i].managerId;
//		    	document.getElementById("row" + i).appendChild(manId);
//		    	
//		    	let firstname = document.createElement("td");
//		    	firstname.className = "firstname";
//		    	firstname.innerHTML = data.reimbursements[i].firstname;
//		    	document.getElementById("row" + i).appendChild(firstname);
//		    	
//		    	let lastname = document.createElement("td");
//		    	lastname.className = "lastname";
//		    	lastname.innerHTML = data.reimbursements[i].lastname;
//		    	document.getElementById("row" + i).appendChild(lastname);
//		    	
//		    	let status = document.createElement("td");
//		    	status.className = "status";
//		    	status.innerHTML = data.reimbursements[i].status;
//		    	document.getElementById("row" + i).appendChild(status);
//		    	
//		    	let amount = document.createElement("td");
//		    	amount.className = "amount";
//		    	amount.innerHTML = data.reimbursements[i].amount;
//		    	document.getElementById("row" + i).appendChild(amount);
//		    	
//		    	let purpose = document.createElement("td");
//		    	purpose.className = "purpose";
//		    	purpose.innerHTML = data.reimbursements[i].purpose;
//		    	document.getElementById("row" + i).appendChild(purpose);
//		}
//		});
//}

function fetchViewEmployees() {
	//send GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/ServletDemo/AllEmployees", {method:"GET", headers:{"Accept":"application/json"}})
	.then(function(response) {
		return response.json();
	}).then(function(data) {
		//check whether there was a valid session
		console.log(data);
		while (RowForBody.firstChild){
			RowForBody.removeChild(RowForBody.firstChild);
		}
		//add status 1 is approved, status 0, pending,
		for(let i=0; i<data.Employees.length;i++){
				
				let row = document.createElement("tr");
		        row.id="row" + i;
		        row.class=row;
		        document.getElementById("RowForBody").appendChild(row);
		    	
		        let rid = document.createElement("td");
		        rid.className="rid";
		        rid.innerHTML=data.Employees[i].id;
		        document.getElementById("row"+i).appendChild(rid);
		        
		    	let firstname = document.createElement("td");
		    	firstname.className = "firstname";
		    	firstname.innerHTML = data.Employees[i].firstName;
		    	document.getElementById("row" + i).appendChild(firstname);
		    	
		    	let lastname = document.createElement("td");
		    	lastname.className = "lastname";
		    	lastname.innerHTML = data.Employees[i].lastName;
		    	document.getElementById("row" + i).appendChild(lastname);
		    	
		    	let username = document.createElement("td");
		    	username.className = "username";
		    	username.innerHTML = data.Employees[i].userName;
		    	document.getElementById("row" + i).appendChild(username);
		   
		    	
		    	let manId = document.createElement("td");
		    	manId.className = "manId";
		    	manId.innerHTML = data.Employees[i].managerId;
		    	document.getElementById("row" + i).appendChild(manId);
		    	
			}
		
		});
}

//function fetchApprovedReim(){
//	fetch("http://localhost:8084/ServletDemo/ViewReim", {method:"GET", headers:{"Accept":"application/json"}})
//	.then(function(response) {
//		return response.json();
//	}).then(function(data) {
//		//check whether there was a valid session
//		console.log(data);
//	
//		while (RowForBody.firstChild){
//			RowForBody.removeChild(RowForBody.firstChild);
//		}
//		//add status 1 is approved, status 0, pending,
//		for(let i=0; i<data.reimbursements.length;i++){
//			if(data.reimbursements[i].status == 1){
//				
//				let row = document.createElement("tr");
//		        row.id="row" + i;
//		        row.class=row;
//		        document.getElementById("RowForBody").appendChild(row);
//		    	
//		        let rid = document.createElement("td");
//		        rid.className="rid";
//		        rid.innerHTML=data.reimbursements[i].reimId;
//		        document.getElementById("row"+i).appendChild(rid);
//		        
//		    
//		    	let manId = document.createElement("td");
//		    	manId.className = "manId";
//		    	manId.innerHTML = data.reimbursements[i].managerId;
//		    	document.getElementById("row" + i).appendChild(manId);
//		    	
//		    	let firstname = document.createElement("td");
//		    	firstname.className = "firstname";
//		    	firstname.innerHTML = data.reimbursements[i].firstname;
//		    	document.getElementById("row" + i).appendChild(firstname);
//		    	
//		    	let lastname = document.createElement("td");
//		    	lastname.className = "lastname";
//		    	lastname.innerHTML = data.reimbursements[i].lastname;
//		    	document.getElementById("row" + i).appendChild(lastname);
//		    	
//		    	let status = document.createElement("td");
//		    	status.className = "status";
//		    	status.innerHTML = data.reimbursements[i].status;
//		    	document.getElementById("row" + i).appendChild(status);
//		    	
//		    	let amount = document.createElement("td");
//		    	amount.className = "amount";
//		    	amount.innerHTML = data.reimbursements[i].amount;
//		    	document.getElementById("row" + i).appendChild(amount);
//		    	
//		    	let purpose = document.createElement("td");
//		    	purpose.className = "purpose";
//		    	purpose.innerHTML = data.reimbursements[i].purpose;
//		    	document.getElementById("row" + i).appendChild(purpose);
//			}
//			} 
//		
//	});
//}

function populateUser() {
	//send GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/ServletDemo/session").then(function(response) {
		//console.log(response);
		return response.json();
	}).then(function(data) {
		//check whether there was a valid session
		console.log(data);
		
		//define behavior for no user returned
		if (data.session === null) {
			window.location = "http://localhost:8084/ServletDemo/login";
		} else {
			//define behavior for user returned
			document.getElementById("username").innerText = "   Logged in as: " + data.user.userName;
			document.getElementById("fullname").innerText = "Welcome "+ data.user.firstName + " " + data.user.lastName;
			document.getElementById("managerId").innerText = "Administrator ";
		}
	});
}