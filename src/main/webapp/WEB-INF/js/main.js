function openProfile(fid, mid) {
	let url = 'profile?fid=' + fid + '&mid=' + mid;
	let title = '프로필 보기';
	let option = 'top=40%, left=40%, width=800px, height=800px';
	window.open(url, title, option);
}

function goChat(nickname) {
	let chatContent = document.getElementsByName('chatContent')[0].value;
	
	$.ajax({
		type: 'POST',
		url: 'goChat',
		data: {
			chatContent: chatContent,
			chatNickname: nickname,			
		},
		success: res => {
			console.log('요청 성공: ', res);
		},
		error: e => {
			console.log('요청 실패: ', e);
		}
	});
	
}

function modalClose() {
	var modal = document.getElementById('wantFModal');
	modal.style.display = 'none';
}