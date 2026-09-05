package com.DoraBash;

import android.util.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: DoraBash.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DoraBash/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.DoraBash.DoraBash$loadLinks$2$1$1$1$1", f = "DoraBash.kt", i = {0, 0, 0, 0}, l = {296}, m = "invokeSuspend", n = {"raw", "parts", "name", "url"}, nl = {303}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
final class DoraBash$loadLinks$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Element $span;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ String $type;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DoraBash this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DoraBash$loadLinks$2$1$1$1$1(Element element, String str, DoraBash doraBash, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super DoraBash$loadLinks$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$span = element;
        this.$type = str;
        this.this$0 = doraBash;
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DoraBash$loadLinks$2$1$1$1$1(this.$span, this.$type, this.this$0, this.$subtitleCallback, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String raw = this.$span.attr("data-embed-id");
                List parts = StringsKt.split$default(raw, new String[]{":"}, false, 2, 2, (Object) null);
                if (parts.size() != 2) {
                    return Unit.INSTANCE;
                }
                String name = StringsKt.replace(MainAPIKt.base64Decode((String) parts.get(0)), this.$type, "", true);
                String url = MainAPIKt.base64Decode((String) parts.get(1));
                Log.d("DoraBash", name + ' ' + this.$type + ' ' + url);
                this.L$0 = SpillingKt.nullOutSpilledVariable(raw);
                this.L$1 = SpillingKt.nullOutSpilledVariable(parts);
                this.L$2 = SpillingKt.nullOutSpilledVariable(name);
                this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                this.label = 1;
                if (DoraBash.loadCustomExtractor$default(this.this$0, name + ' ' + this.$type, url, url, this.$subtitleCallback, this.$callback, null, (Continuation) this, 32, null) == coroutine_suspended) {
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
}
