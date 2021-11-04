var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            console.log("test");
            _this.save();
        });

        $('#btn-update').on('click',function(){ //btn-update란 id를 가진 HTML 엘리먼트에 click 이벤트가 발생할 때 update function을 실행하도록 이벤트를 등록.
            _this.update();
        });

        $('#btn-delete').on('click',function(){
            _this.delete();
        });

        $('#btn-smr-info').on('click', function () {
            _this.summoner_info();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST', // REST규약에서 CRUD는 HTTP Method와 다음과 같이 매핑됨 - C: POST, R: GET, U: PUT, D: DELETE
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',    // 여러 HTTP Method 중 PUT 메소드를 선택. PostsApiController에 있는 API에서 이미 @PutMapping으로 선언해서 PUT 사용해야함
            url: '/api/v1/posts/'+id, // 수정할 게시물
            dataType: 'json',   // 수정 된 정보를 가지고 와 data 를 JSON 형식으로 바꿔서 PostsApiController에 보낼 예정
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href='/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
/*
    summoner_info : function () {
        const nickname = $('#summoner').val();

        $.ajax({
            type: 'GET',
            url: '/api/v1/user/lol/'+summoner,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (res) {
            alert(JSON.stringify(res));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }*/
};

main.init();