import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            songs: [{
                id: Number,
                artistName: String,
                songName: String,
                date: String,
                path: String,
            },
            ],
            songlist: [
                {
                    url: "",
                    artist: {
                        name: "",
                        song: ''
                    }
                },
            ]
        };
    }

    componentWillMount() {
        this.loadSong();
    }

    render() {
        return (
            <div>
                <img src={require('../img/vsa pieni.png')} />
                <text style={{fontSize: 25}}>SONGLIST</text>
                <SongsTable song={this.state.songs}/>
            </div>
        );
    }
    loadSong() {
        fetch('http://localhost:8080/list')
            .then((response) => response.json())
            .then((responseJson) => {
                let placeholdersonglist = [];
                this.setState({songs: responseJson, songlist: placeholdersonglist});

            });

    };
}



class SongsTable extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        let songprop = this.props.song;
        console.log("songprop",songprop);
        function onAfterDeleteRow(rowKeys, rows) {
            alert('Removed rows : ' + rowKeys);
            for (let i = 0; i < rowKeys.length; i++) {
                fetch('http://localhost:8080/delete' + '/' + rowKeys[i], {credentials: 'same-origin'});
            }
        }
        function musicFormatter(rowKeys, rows) {
            return <audio  src={rows.path} controls>
                <embed  autostart="0" />
            </audio>

        }
        const options = {
            afterDeleteRow: onAfterDeleteRow  // A hook for after droping rows.
        };
        const selectRowProp = {
            mode: 'checkbox'
        };
        const cellEditProp = {
            mode: 'click',
            blurToSave: true
        };
        return (
            <div>
            <BootstrapTable data={songprop} striped hover
                            options={ options }
                            deleteRow={ true }
                            selectRow={ selectRowProp }
                            cellEdit={ cellEditProp }
                            exportCSV>
                <TableHeaderColumn  width="150" isKey dataField='id'>Song ID</TableHeaderColumn>
                <TableHeaderColumn width="150" dataField='songName'>Song Name</TableHeaderColumn>
                <TableHeaderColumn width="150" dataField='artistName'>Artist Name</TableHeaderColumn>
                <TableHeaderColumn width="150" dataField='date'>Date</TableHeaderColumn>
                <TableHeaderColumn dataFormat={ musicFormatter }>Player</TableHeaderColumn>
            </BootstrapTable>
            </div>
        );
    }
}
ReactDOM.render(<App/>, document.getElementById('root') );