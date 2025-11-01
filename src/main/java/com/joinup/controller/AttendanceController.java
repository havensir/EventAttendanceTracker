/**
 * Controller class responsible for handling HTTP requests related to event attendance.
 * Provides endpoints for registering, removing, and listing attendees.
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    /**
     * Registers a new attendee via HTTP POST.
     *
     * @param attendeeName Name of the attendee
     * @return ResponseEntity indicating success or failure
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String attendeeName) {
        // existing logic
    }

    /**
     * Removes an attendee via HTTP DELETE.
     *
     * @param attendeeName Name of the attendee
     * @return ResponseEntity indicating success or failure
     */
    @DeleteMapping("/remove")
    public ResponseEntity<String> remove(@RequestParam String attendeeName) {
        // existing logic
    }
}
