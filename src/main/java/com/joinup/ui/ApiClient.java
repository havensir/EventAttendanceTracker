package com.joinup.ui;

/**
 * API client contract the UI layer uses to communicate with backend tier.
 * For Milestone 1 we return raw JSON strings to keep things simple.
 * Later milestones can swap this with a real HTTP client returning DTOs.
 */
public interface ApiClient {
    String getEventsJson();
    String getAttendeesJson(Long eventId);
    String getCheckinsJson(Long eventId);
}
