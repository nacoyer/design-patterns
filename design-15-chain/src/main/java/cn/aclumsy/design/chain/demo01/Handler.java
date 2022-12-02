
/*
 * Copyright (c) 2022, Aclumsy.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *                _
 *      /\       | |
 *     /  \   ___| |_   _ _ __ ___  ___ _   _
 *    / /\ \ / __| | | | | '_ ` _ \/ __| | | |
 *   / ____ \ (__| | |_| | | | | | \__ \ |_| |
 *  /_/    \_\___|_|\__,_|_| |_| |_|___/\__, |
 *                                       __/ |
 *                                      |___/
 *  I'll think of you every step of the way.
 *  without your world, I don't want to stay for a moment.
 */
package cn.aclumsy.design.chain.demo01;

/**
 * 抽象处理者
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public abstract class Handler {

    protected static final int ONE = 1;

    protected static final int THREE = 3;

    protected static final int SEVEN = 7;

    private Integer numStart;

    private Integer numEnd;

    private Handler nextHandler;

    public Handler(Integer numStart) {
        this.numStart = numStart;
    }

    public Handler(Integer numStart, Integer numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 处理请假请求
     * @param leaveRequest 请假请求
     */
    protected abstract void handle(LeaveRequest leaveRequest);

    /**
     * 处理请假请求
     * @param leaveRequest 请假请求
     */
    public final void submit(LeaveRequest leaveRequest) {
        this.handle(leaveRequest);
        if (this.nextHandler != null && leaveRequest.getDays() > this.numEnd) {
            this.nextHandler.submit(leaveRequest);
        } else {
            System.out.println("结束");
        }
    }

}
