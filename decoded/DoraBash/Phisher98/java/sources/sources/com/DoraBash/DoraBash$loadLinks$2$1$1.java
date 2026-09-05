package com.DoraBash;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: DoraBash.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DoraBash/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.DoraBash.DoraBash$loadLinks$2$1$1", f = "DoraBash.kt", i = {0, 0}, l = {304}, m = "invokeSuspend", n = {"$this$async", "type"}, nl = {305}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nDoraBash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBash$loadLinks$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,342:1\n1739#2:343\n1814#2,3:344\n*S KotlinDebug\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBash$loadLinks$2$1$1\n*L\n288#1:343\n288#1:344,3\n*E\n"})
final class DoraBash$loadLinks$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Element $container;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DoraBash this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DoraBash$loadLinks$2$1$1(Element element, DoraBash doraBash, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super DoraBash$loadLinks$2$1$1> continuation) {
        super(2, continuation);
        this.$container = element;
        this.this$0 = doraBash;
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> doraBash$loadLinks$2$1$1 = new DoraBash$loadLinks$2$1$1(this.$container, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        doraBash$loadLinks$2$1$1.L$0 = obj;
        return doraBash$loadLinks$2$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$container.hasClass("player-dub")) {
                    str = "DUB";
                } else {
                    if (!this.$container.hasClass("player-sub")) {
                        return Unit.INSTANCE;
                    }
                    str = "SUB";
                }
                String type = str;
                Iterable $this$map$iv = this.$container.select("span[data-embed-id]");
                DoraBash doraBash = this.this$0;
                Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
                Function1<ExtractorLink, Unit> function2 = this.$callback;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element span = (Element) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$async, (CoroutineContext) null, (CoroutineStart) null, new DoraBash$loadLinks$2$1$1$1$1(span, type, doraBash, function1, function2, null), 3, (Object) null));
                    type = type;
                    doraBash = doraBash;
                    function1 = function1;
                    function2 = function2;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                this.L$1 = SpillingKt.nullOutSpilledVariable(type);
                this.label = 1;
                if (AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
