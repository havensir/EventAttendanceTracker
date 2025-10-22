package com.joinup.ui;

/**
 * Stub implementation used in Milestone 1.
 * This can be swapped later with a real HTTP-backed client that calls /api/... endpoints.
 */
public class StubApiClient implements ApiClient {

    @Override
    public String getEventsJson() {
        return """
        [
          {"id":1,"name":"Hack Night","date":"2025-11-01"},
          {"id":2,"name":"UX Shareout","date":"2025-11-05"}
        ]
        """;
    }

    @Override
    public String getAttendeesJson(Long eventId) {
        // eventId is ignored in stub; included to match real signature later
        return """
        [
          {"id":101,"eventId":1,"name":"Alex A."},
          {"id":102,"eventId":1,"name":"Riley R."}
        ]
        """;
    }

    @Override
    public String getCheckinsJson(Long eventId) {
        // eventId is ignored in stub; included to match real signature later
        return """
        [
          {"id":1001,"eventId":1,"attendeeId":101,"checkedIn":true},
          {"id":1002,"eventId":1,"attendeeId":102,"checkedIn":false}
        ]
        """;
    }
}
