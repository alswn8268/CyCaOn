function openProfile(fid, mid) {
	let url = 'profile?fid=' + fid + '&mid=' + mid;
	let title = '프로필 보기';
	let option = 'top=40%, left=40%, width=800px, height=800px';
	window.open(url, title, option);
}