<html>
<body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- <script>
    $(document).ready(function() {
        $.active = false;
        $('body').bind('click keypress', function() { $.active = true; });
        checkActivity(1800000, 60000, 0); // timeout = 30 minutes, interval = 1 minute.
    });

    function checkActivity(timeout, interval, elapsed) {
        if ($.active) {
            elapsed = 0;
            $.active = false;
            $.get('heartbeat');
        }
        if (elapsed < timeout) {
            elapsed += interval;
            setTimeout(function() {
                checkActivity(timeout, interval, elapsed);
            }, interval);
        } else {
            window.location = 'http://localhost:8082/logout'; // Redirect to "session expired" page.
        }
    }
</script> -->
<h1>Successfully Logged In</h1>
<a href="/logout">Logout</a>
</body>
</html>