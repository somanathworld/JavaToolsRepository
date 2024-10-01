/**
 * 
 */

function validate(frm) {
	let ename = frm.eName.value;
	let job = frm.job.value;
	let sal = frm.salary.value;
	let flag = true;

	if (ename == "") {
		flag = false;
		document.getElementById("enameId").innerHTML = "Employee name is mandatory(js)";
		frm.eName.focus();
	}
	else if (ename.length < 5 || ename.length > 10) {
		flag = false;
		document.getElementById("enameId").innerHTML = "Employee name must have min of 5 chars and max of 10 chars (js)";
		frm.eName.focus();
	}
	if (job == "") {
		flag = false;
		document.getElementById("jobId").innerHTML = "Employee job is mandatory(js)";
		frm.job.focus();
	}
	else if (job.length < 5 || job.length > 9) {
		flag = false;
		document.getElementById("jobId").innerHTML = "Employee job must have min of 5 chars and max of 9 chars (js)";
	}
	if (sal == "") {
		flag = false;
		document.getElementById("salId").innerHTML = "Employee sal is mandatory(js)";
	}
	else if (isNaN(sal)) {
		flag = false;
		document.getElementById("salId").innerHTML = "Employee sal is must be numeric vlaue(js)";
	}
	else if (sal < 10000 || sal > 100000) {
		flag = false;
		document.getElementById("salId").innerHTML = "Employee salary must be in the range between 10000 to 100000(js)";
	}
	return flag;
}