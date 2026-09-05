package com.phisher98;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$Companion$getApiBase$4$workingProxy$1", f = "StreamPlay.kt", i = {0, 0}, l = {125}, m = "invokeSuspend", n = {"$this$coroutineScope", "deferredChecks"}, nl = {934}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$Companion$getApiBase$4$workingProxy$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,929:1\n1739#2:930\n1814#2,3:931\n296#2,2:934\n*S KotlinDebug\n*F\n+ 1 StreamPlay.kt\ncom/phisher98/StreamPlay$Companion$getApiBase$4$workingProxy$1\n*L\n120#1:930\n120#1:931,3\n125#1:934,2\n*E\n"})
final class StreamPlay$Companion$getApiBase$4$workingProxy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ List<String> $proxies;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$Companion$getApiBase$4$workingProxy$1(List<String> list, Continuation<? super StreamPlay$Companion$getApiBase$4$workingProxy$1> continuation) {
        super(2, continuation);
        this.$proxies = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlay$Companion$getApiBase$4$workingProxy$1 = new StreamPlay$Companion$getApiBase$4$workingProxy$1(this.$proxies, continuation);
        streamPlay$Companion$getApiBase$4$workingProxy$1.L$0 = obj;
        return streamPlay$Companion$getApiBase$4$workingProxy$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$proxies;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String proxy = (String) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0063x17c6b087(proxy, null), 3, (Object) null));
                }
                List deferredChecks = (List) destination$iv$iv;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredChecks);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll(deferredChecks, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$firstOrNull$iv = (Iterable) objAwaitAll;
        for (Object element$iv : $this$firstOrNull$iv) {
            String it = (String) element$iv;
            if (it != null) {
                return element$iv;
            }
        }
        return null;
    }
}
