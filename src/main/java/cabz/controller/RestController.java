package cabz.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cabz.common.JsonRestObject;

/**
 * User: Joseph Vartuli
 * Date: 25/08/12
 *
 * @since:
 */
@Controller
@RequestMapping("/apitest")
@Secured("ROLE_USER")
public class RestController {


    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
    public @ResponseBody JsonRestObject getJsonRestObject(@PathVariable Integer id) {
        return new JsonRestObject(id);
    }

}
