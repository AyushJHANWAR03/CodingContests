package com.crio.codingame.commands;


import java.util.List;

import com.crio.codingame.dtos.UserRegistrationDto;

import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.exceptions.UserNotFoundException;

import com.crio.codingame.services.IUserService;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;
    
    public AttendContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute attendContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["ATTEND_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        try{
            String contestid = tokens.get(1);
            String username = tokens.get(2);
            
            UserRegistrationDto result = userService.attendContest(contestid, username);
            
            System.out.println(result);
            
        } /* catch(ContestNotFoundException e){
            System.out.println("Cannot Attend Contest. Contest for given id:1 not found!");
        } catch(UserNotFoundException e){
            String username = tokens.get(2);
            System.out.println("Cannot Attend Contest. User for given name:"+ username +" not found!");
        }  */
        catch(ContestNotFoundException cnt)
        {
            String contestid = tokens.get(1);
            String expectedOutput = "Cannot Attend Contest. Contest for given id:"+contestid+" not found!";
            System.out.println(expectedOutput);
        }
        catch(UserNotFoundException usc)
        {
            String username = tokens.get(2);
            String expectedOutput = "Cannot Attend Contest. User for given name:"+ username+" not found!";
            System.out.println(expectedOutput);
        }
        
        catch (InvalidOperationException e){
            
            System.out.println(e.getMessage());       
           
        } 
    }
    
}
