var CommentForm = React.createClass({
    getInitialState: function () {
        return ({
            result: "null",
            username: "",
            content: ""
        });
    },

    submitComment: function () {
        console.log(this.state.username);
        this.props.onSubmitForm({username: this.state.username, content: this.state.content});
    },
    handleUsernameChange: function(e) {
        this.setState({username: e.target.value});
    },
    handleContentChange: function(e) {
        this.setState({content: e.target.value});
    },

    render: function () {
        return (
            <form method="post">
                <input type="text" name="username" id="username" placeholder="name"  onChange={this.handleUsernameChange}/>
                <input type="text" name="psw" id="psw" placeholder="psw" onChange={this.handleContentChange}/>
                <input type="button" value="TJ"
                       onClick={this.submitComment}/>
            </form>
        )
    }
});


var CommentList = React.createClass({
    render: function () {
        // if (!this.props.commentList) {
            return (
                <div className="commentList1">
                    {
                        this.props.commentList.map(function (comment) {
                            return (
                                <div>
                                    <p>{comment.username}</p>
                                    <p>{comment.content}</p>
                                </div>
                            );
                        })
                    }
                </div>
            )
        // } else {
        //     return (<div>
        //         <p>No comments</p>
        //     </div>);
        // }
    }
});


var CommentComponent = React.createClass({
    getInitialState: function () {
        return (
            {commentList: []}
        )
    },
    componentDidMount: function () {
        $.ajax({
            type: "GET",
            url: "/comment/list",
            dataType: "json",
            success: function (data) {
                this.setState({
                    commentList: data
                });
            }.bind(this)
        });
    },
    submitForm: function (comment) {
        $.ajax({
            type: "POST",
            url: "/comment/add",
            dataType: "json",
            data: {username: comment.username, content: comment.content},
            success: function (data) {
                this.setState({
                    commentList: data
                });
            }.bind(this)
        });
    },
    render: function () {
        //post请求，把结果作为参数传递给commentList,setState
        //提交评论后，将返回值传给commentList,setState
        return (
            <div>
                <CommentForm onSubmitForm={this.submitForm}/>
                <br/>
                <br/>
                <p>我是分界线</p>
                <br/>
                <br/>
                <CommentList commentList={this.state.commentList}/>
            </div>
        )
    }
});


ReactDOM.render(<CommentComponent/>, document.getElementById("commentComponent"));
