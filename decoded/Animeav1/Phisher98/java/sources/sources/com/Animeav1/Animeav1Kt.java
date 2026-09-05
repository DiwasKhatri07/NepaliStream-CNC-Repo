package com.Animeav1;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Animeav1.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animeav1/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001ab\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"loadCustomExtractor", "", "name", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "quality", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animeav1"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class Animeav1Kt {

    /* JADX INFO: renamed from: com.Animeav1.Animeav1Kt$loadCustomExtractor$1 */
    /* JADX INFO: compiled from: Animeav1.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Animeav1Kt", f = "Animeav1.kt", i = {0, 0, 0, 0, 0, 0}, l = {218}, m = "loadCustomExtractor", n = {"name", "url", "referer", "subtitleCallback", "callback", "quality"}, nl = {237}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Animeav1Kt.loadCustomExtractor(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object loadCustomExtractor(@Nullable final String name, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull Continuation<? super Unit> continuation) {
        C00081 c00081;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1 function3 = new Function1() { // from class: com.Animeav1.Animeav1Kt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return Animeav1Kt.loadCustomExtractor$lambda$0(function2, name, quality, (ExtractorLink) obj);
                    }
                };
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(name);
                c00081.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00081.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00081.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00081.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00081.L$5 = SpillingKt.nullOutSpilledVariable(quality);
                c00081.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00081) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object loadCustomExtractor$default(String str, String str2, String str3, Function1 function1, Function1 function2, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        return loadCustomExtractor(str, str2, str3, function1, function2, num, continuation);
    }

    static final Unit loadCustomExtractor$lambda$0(Function1 $callback, String $name, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Animeav1Kt$loadCustomExtractor$2$1($callback, $name, link, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
