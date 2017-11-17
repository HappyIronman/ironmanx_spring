var CommentForm = React.createClass({
    getInitialState: function () {
        return ({
            result: "null",
            username: null,
            content: null
        });
    },

    render: function () {
        return (
            <form method="post">
                <input type="text" name="username" id="username" placeholder="name" value={this.state.username}/>
                <input type="text" name="psw" id="psw" placeholder="psw" value={this.state.content}/>
                <input type="button" value="TJ"
                       onClick={this.props.submitForm({username: this.state.username, psw: this.state.content})}/>
            </form>
        )
    }
});

// ReactDOM.render(<CommentForm/>, document.getElementById("loginForm"));
