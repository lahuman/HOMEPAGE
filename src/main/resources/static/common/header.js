var Header = React.createClass({
    render: function() {
        return <div>Hello {this.props.name}</div>;
    }
});

ReactDOM.render(
	<Header name="World" />,
	document.getElementById('header')
);
