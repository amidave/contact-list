const search=() =>{
	let query=$("#search-input").val();
	
	if(query==''){
		$(".search-result").hide();
	}else{
		//search
		let url='http://localhost:8282/search/'+query;
		fetch(url).then(response=>{
			return response.json();
		}).then((data) =>{
			let text = "<div class='list-group'>";
			
			data.forEach(contact=>{
				text += "<span class='list-group-item list-group-action'>"+contact.name+"</span>"
			});
			
			text += '</div>';
			
			$(".search-result").html(text);
			$(".search-result").show();
		});
	}
};
