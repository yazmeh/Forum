/**
 * 
 */

function validateQues() {
	var y = document.forms["myForm"]["ques"].value;
	if (y == "") {
        alert("Question must be filled out");
        return false;
    }
	return true;
}
function validateAuth() {
	var y = document.forms["myForm"]["auth"].value;
	if (y == "") {
        alert("Author name is required");
        return false;	
    }
	return true;
}
function validateSearch() {
	var y = document.forms["search"]["key"].value;
	if (y == "") {
        alert("Key word must be filled out");
        return false;	
    }
	return true;
}
function validateSal() {
	var z = document.forms["myForm"]["sal"].value;
	if (z == "") {
        alert("Salary must be filled out");
        return false;
    }
	return true;
}
function validateForm1()
{
	if(validateQues() && validateAuth())
	{
		return true;
	}
	return false;
}
function validateForm2()
{
	if(validateAns() && validateAuth())
	{
		return true;
	}
	return false;
}

