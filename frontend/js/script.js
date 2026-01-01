 // Station data - you can expand this list with more stations
    const stations = [
        { name: "New Delhi", code: "NDLS" },
        { name: "Mumbai Central", code: "MMCT" },
        { name: "Chennai Central", code: "MAS" },
        { name: "Kolkata", code: "KOAA" },
        { name: "Bangalore City", code: "SBC" },
        { name: "Hyderabad Deccan", code: "HYB" },
        { name: "Pune Junction", code: "PUNE" },
        { name: "Ahmedabad Junction", code: "ADI" },
        { name: "Jaipur Junction", code: "JP" },
        { name: "Lucknow", code: "LKO" },
        { name: "Kanpur Central", code: "CNB" },
        { name: "Nagpur Junction", code: "NGP" },
        { name: "Bhopal Junction", code: "BPL" },
        { name: "Indore Junction", code: "INDB" },
        { name: "Patna Junction", code: "PNBE" },
        { name: "Guwahati", code: "GHY" },
        { name: "Trivandrum Central", code: "TVC" },
        { name: "Kochi", code: "ERS" },
        { name: "Coimbatore Junction", code: "CBE" },
        { name: "Madurai Junction", code: "MDU" },
        { name: "Vijayawada Junction", code: "BZA" },
        { name: "Visakhapatnam", code: "VSKP" },
        { name: "Bhubaneswar", code: "BBS" },
        { name: "Raipur Junction", code: "R" },
        { name: "Bilaspur Junction", code: "BSP" },
        { name: "Jabalpur", code: "JBP" },
        { name: "Agra Cantonment", code: "AGC" },
        { name: "Allahabad Junction", code: "ALD" },
        { name: "Varanasi Junction", code: "BSB" },
        { name: "Gorakhpur Junction", code: "GKP" },
        { name: "Dehradun", code: "DDN" },
        { name: "Haridwar Junction", code: "HW" },
        { name: "Amritsar Junction", code: "ASR" },
        { name: "Jammu Tawi", code: "JAT" },
        { name: "Chandigarh", code: "CDG" },
        { name: "Jodhpur Junction", code: "JU" },
        { name: "Udaipur City", code: "UDZ" },
        { name: "Kota Junction", code: "KOTA" },
        { name: "Ajmer Junction", code: "AII" },
        { name: "Bikaner Junction", code: "BKN" }
    ];

    // Initialize dropdowns when page loads
    document.addEventListener('DOMContentLoaded', function() {
        populateStationDropdowns();
        loadAllTrains(); // Load all trains on page load
        console.log('Train Search Frontend loaded successfully!');
    });

    let currentView = 'search';

    function switchView(view) {
        currentView = view;

        // Update tab buttons
        document.querySelectorAll('.card-tab').forEach(btn => btn.classList.remove('active'));
        event.target.classList.add('active');

        // Show/hide views
        const searchView = document.getElementById('searchView');
        const allTrainsView = document.getElementById('allTrainsView');
        const resultsSection = document.getElementById('resultsSection');

        if (view === 'search') {
            searchView.style.display = 'block';
            allTrainsView.style.display = 'none';
            // Keep results section visible if there are search results
        } else {
            searchView.style.display = 'none';
            allTrainsView.style.display = 'block';
            resultsSection.style.display = 'none'; // Hide search results when viewing all trains
            loadAllTrains();
        }
    }

    async function loadAllTrains() {
        const refreshBtn = document.getElementById('refreshBtn');
        const allTrainsContainer = document.getElementById('allTrainsContainer');

        // Show loading state
        refreshBtn.disabled = true;
        refreshBtn.innerHTML = '🔄 Loading...';
        allTrainsContainer.innerHTML = `
            <div class="loading">
                <div class="spinner"></div>
                <p>Loading all available trains...</p>
            </div>
        `;

        try {
            const response = await fetch('http://localhost:8080/train');

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const trains = await response.json();
            displayAllTrains(trains);

        } catch (error) {
            console.error('Error fetching all trains:', error);
            allTrainsContainer.innerHTML = `
                <div class="error">
                    <h3>Error occurred while loading trains</h3>
                    <p>Please check if the API server is running on localhost:8080 and try again.</p>
                    <p>Error: ${error.message}</p>
                </div>
            `;
        } finally {
            refreshBtn.disabled = false;
            refreshBtn.innerHTML = '🔄 Refresh';
        }
    }

    function displayAllTrains(trains) {
        const allTrainsContainer = document.getElementById('allTrainsContainer');

        if (!trains || trains.length === 0) {
            allTrainsContainer.innerHTML = `
                <div class="no-results">
                    <div class="no-results-icon">🚂</div>
                    <h3>No trains available</h3>
                    <p>No trains found in the database</p>
                </div>
            `;
            return;
        }

        const trainsHtml = trains.map(train => `
            <div class="train-info-card fade-in">
                <div class="train-info-header">
                    <div class="train-info-name">${train.trainname}</div>
                    <div class="train-info-number">${train.trainnumber}</div>
                </div>
            </div>
        `).join('');

        allTrainsContainer.innerHTML = `
            <div style="margin-bottom: 1rem; color: #666; font-weight: 600;">
                Total Trains: ${trains.length}
            </div>
            ${trainsHtml}
        `;
    }

    function populateStationDropdowns() {
        const sourceSelect = document.getElementById('sourceStation');
        const destSelect = document.getElementById('destStation');

        // Sort stations alphabetically
        const sortedStations = [...stations].sort((a, b) => a.name.localeCompare(b.name));

        sortedStations.forEach(station => {
            const sourceOption = new Option(`${station.name} (${station.code})`, JSON.stringify(station));
            const destOption = new Option(`${station.name} (${station.code})`, JSON.stringify(station));

            sourceSelect.appendChild(sourceOption);
            destSelect.appendChild(destOption);
        });
    }

    function swapStations() {
        const sourceSelect = document.getElementById('sourceStation');
        const destSelect = document.getElementById('destStation');

        const tempValue = sourceSelect.value;
        sourceSelect.value = destSelect.value;
        destSelect.value = tempValue;
    }

    async function searchTrains(event) {
        event.preventDefault();

        const sourceSelect = document.getElementById('sourceStation');
        const destSelect = document.getElementById('destStation');
        const searchBtn = document.getElementById('searchBtn');
        const resultsSection = document.getElementById('resultsSection');
        const resultsContainer = document.getElementById('resultsContainer');

        if (!sourceSelect.value || !destSelect.value) {
            alert('Please select both source and destination stations');
            return;
        }

        if (sourceSelect.value === destSelect.value) {
            alert('Source and destination stations cannot be the same');
            return;
        }

        const sourceStation = JSON.parse(sourceSelect.value);
        const destStation = JSON.parse(destSelect.value);

        // Show loading state
        searchBtn.disabled = true;
        searchBtn.innerHTML = 'Searching...';
        resultsSection.style.display = 'block';
        resultsContainer.innerHTML = `
            <div class="loading">
                <div class="spinner"></div>
                <p>Searching for trains from ${sourceStation.name} to ${destStation.name}...</p>
            </div>
        `;

        try {
            // Try search by name first
            let apiUrl = `http://localhost:8080/search/by-name?sourcename=${encodeURIComponent(sourceStation.name)}&destinationname=${encodeURIComponent(destStation.name)}`;
            let response = await fetch(apiUrl);
            let trains = [];

            if (response.ok) {
                trains = await response.json();
            }

            // If no results with names, try with codes
            if (!trains || trains.length === 0) {
                apiUrl = `http://localhost:8080/search/by-code?sourcecode=${encodeURIComponent(sourceStation.code)}&destinationcode=${encodeURIComponent(destStation.code)}`;
                response = await fetch(apiUrl);

                if (response.ok) {
                    trains = await response.json();
                }
            }

            displayResults(trains, sourceStation, destStation);

        } catch (error) {
            console.error('Error fetching trains:', error);
            resultsContainer.innerHTML = `
                <div class="error">
                    <h3>Error occurred while searching</h3>
                    <p>Please check if the API server is running on localhost:8080 and try again.</p>
                    <p>Error: ${error.message}</p>
                </div>
            `;
        } finally {
            searchBtn.disabled = false;
            searchBtn.innerHTML = 'Search Trains';
        }
    }

    function displayResults(trains, sourceStation, destStation) {
        const resultsContainer = document.getElementById('resultsContainer');
        const resultsCount = document.getElementById('resultsCount');

        if (!trains || trains.length === 0) {
            resultsContainer.innerHTML = `
                <div class="no-results">
                    <div class="no-results-icon">🚫</div>
                    <h3>No trains found</h3>
                    <p>No direct trains available from ${sourceStation.name} to ${destStation.name}</p>
                    <p>Try selecting different stations or check for connecting trains</p>
                </div>
            `;
            resultsCount.textContent = '0 trains found';
            return;
        }

        resultsCount.textContent = `${trains.length} train${trains.length > 1 ? 's' : ''} found`;

        const trainsHtml = trains.map(train => `
            <div class="train-card fade-in">
                <div class="train-header">
                    <div class="train-name">${train.train.trainname}</div>
                    <div class="train-number">${train.train.trainnumber}</div>
                </div>
                <div class="route-info">
                    <div class="station">
                        <div class="station-info">
                            <div class="station-main">${train.source.stationname}</div>
                            <div class="station-sub">${train.source.stationcode}</div>
                        </div>
                        <div class="time">${train.departuretimetime}</div>
                    </div>
                    <div class="route-arrow">
                        <div class="arrow"></div>
                    </div>
                    <div class="station">
                        <div class="station-info">
                            <div class="station-main">${train.destination.stationname}</div>
                            <div class="station-sub">${train.destination.stationcode}</div>
                        </div>
                        <div class="time">${train.arrivaltime}</div>
                    </div>
                </div>
            </div>
        `).join('');

        resultsContainer.innerHTML = trainsHtml;
    }

    function calculateDuration(departure, arrival) {
        const [depHours, depMinutes] = departure.split(':').map(Number);
        const [arrHours, arrMinutes] = arrival.split(':').map(Number);

        let depTotalMinutes = depHours * 60 + depMinutes;
        let arrTotalMinutes = arrHours * 60 + arrMinutes;

        // If arrival time is less than departure time, assume next day
        if (arrTotalMinutes < depTotalMinutes) {
            arrTotalMinutes += 24 * 60;
        }

        const durationMinutes = arrTotalMinutes - depTotalMinutes;
        const hours = Math.floor(durationMinutes / 60);
        const minutes = durationMinutes % 60;

        return `${hours}h ${minutes}m`;
    }