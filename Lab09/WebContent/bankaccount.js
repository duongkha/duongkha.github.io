"use strict";

var banking = (function(){
	var accountInfoList = [];
	function Account(name,deposit){
		this.name = name;
		this.deposit = deposit;
	};
	var newAccount = function(){
		let name = document.getElementById("accountName").value;
		let deposit = document.getElementById("deposit").value;
		let depositVal = parseFloat(deposit);
		if(name !== "" && deposit !== ""){
			let isUpdate = false;
			if(accountInfoList.length > 0){
				for(let i = 0; i < accountInfoList.length;i++){
					if(accountInfoList[i].name === name){
						accountInfoList[i].deposit += depositVal;
						isUpdate = true;
						break;
					}
				}
			}
			if(!isUpdate){
				var acc = new Account(name, depositVal);
				accountInfoList.push(acc);
			}
		}
		print();
	}
	var getaccountInfoList = function(){
		return accountInfoList;
	}
	var print = function(){
		let s = "";
		if(accountInfoList !== null)
			for(let i = 0; i < accountInfoList.length;i++){
				s += "Account Name: " + accountInfoList[i].name + " Balance: " +  accountInfoList[i].deposit + "\n";
			}
		document.getElementById("output").innerHTML = s;
	}
	return{
		newAccount,
		getaccountInfoList,
		print
	}
})();