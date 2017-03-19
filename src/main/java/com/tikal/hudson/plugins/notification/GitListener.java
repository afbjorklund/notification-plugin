/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tikal.hudson.plugins.notification;

import hudson.Extension;
import hudson.FilePath;
import hudson.model.TaskListener;
import hudson.model.Run;
import hudson.model.listeners.SCMListener;
import hudson.scm.ChangeLogSet;
import hudson.scm.SCM;
import hudson.scm.SCMRevisionState;
import java.io.File;

@Extension
@SuppressWarnings("rawtypes")
public class GitListener extends SCMListener {

    @Override
    public void onCheckout(Run<?,?> r, SCM scm, FilePath workspace, TaskListener listener, File changelogFile, SCMRevisionState pollingBaseline) {
        Phase.CHECKOUT.handle(r, listener, r.getTimeInMillis());
    }

    @Override
    public void onChangeLogParsed(Run<?,?> r, SCM scm, TaskListener listener, ChangeLogSet<?> changelog) {
        Phase.CHANGELOG.handle(r, listener, r.getTimeInMillis());
    }

}
