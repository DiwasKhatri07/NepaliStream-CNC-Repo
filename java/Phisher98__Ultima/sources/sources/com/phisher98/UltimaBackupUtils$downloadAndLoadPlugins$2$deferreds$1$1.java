package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.plugins.PluginWrapper;
import com.lagradost.cloudstream3.plugins.RepositoryManager;
import com.lagradost.cloudstream3.ui.settings.extensions.RepositoryData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UltimaBackupUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/plugins/PluginWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$2$deferreds$1$1", f = "UltimaBackupUtils.kt", i = {}, l = {505}, m = "invokeSuspend", n = {}, nl = {506}, s = {}, v = 2)
final class UltimaBackupUtils$downloadAndLoadPlugins$2$deferreds$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PluginWrapper>>, Object> {
    final /* synthetic */ RepositoryData $repo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaBackupUtils$downloadAndLoadPlugins$2$deferreds$1$1(RepositoryData repositoryData, Continuation<? super UltimaBackupUtils$downloadAndLoadPlugins$2$deferreds$1$1> continuation) {
        super(2, continuation);
        this.$repo = repositoryData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaBackupUtils$downloadAndLoadPlugins$2$deferreds$1$1(this.$repo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PluginWrapper>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object repoPlugins;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    repoPlugins = RepositoryManager.INSTANCE.getRepoPlugins(this.$repo, (Continuation) this);
                    if (repoPlugins == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    repoPlugins = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (List) repoPlugins;
        } catch (Exception e) {
            Log.INSTANCE.e("UltimaSync", "Failed to fetch plugins for repo " + this.$repo.getUrl() + ": " + e.getMessage());
            return null;
        }
    }
}
