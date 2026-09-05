package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import kotlin.Metadata;
import kotlin.Result;
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

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UtilsKt$loadCustomExtractor$2$1$1", f = "Utils.kt", i = {0, 0, 0}, l = {41}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "finalName"}, nl = {40}, s = {"L$0", "L$1", "L$2"}, v = 2)
final class UtilsKt$loadCustomExtractor$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ ExtractorLink $link;
    final /* synthetic */ String $name;
    final /* synthetic */ Integer $quality;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UtilsKt$loadCustomExtractor$2$1$1(String str, ExtractorLink extractorLink, Function1<? super ExtractorLink, Unit> function1, Integer num, Continuation<? super UtilsKt$loadCustomExtractor$2$1$1> continuation) {
        super(2, continuation);
        this.$name = str;
        this.$link = extractorLink;
        this.$callback = function1;
        this.$quality = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> utilsKt$loadCustomExtractor$2$1$1 = new UtilsKt$loadCustomExtractor$2$1$1(this.$name, this.$link, this.$callback, this.$quality, continuation);
        utilsKt$loadCustomExtractor$2$1$1.L$0 = obj;
        return utilsKt$loadCustomExtractor$2$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String finalName;
        Object obj;
        Function1<ExtractorLink, Unit> function1;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$name;
                    ExtractorLink extractorLink = this.$link;
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    Integer num = this.$quality;
                    Result.Companion companion = Result.Companion;
                    if (str != null) {
                        if (StringsKt.contains(extractorLink.getName(), "Download", true) && !StringsKt.contains(str, "Download", true)) {
                            finalName = StringsKt.replace$default(str, "Kwik", "Kwik [Download]", false, 4, (Object) null);
                        } else {
                            finalName = str;
                        }
                    } else {
                        finalName = extractorLink.getName();
                    }
                    String url = extractorLink.getUrl();
                    UtilsKt$loadCustomExtractor$2$1$1$1$1 utilsKt$loadCustomExtractor$2$1$1$1$1 = new UtilsKt$loadCustomExtractor$2$1$1$1$1(num, extractorLink, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(finalName);
                    this.L$3 = function2;
                    this.label = 1;
                    Object objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(finalName, finalName, url, (ExtractorLinkType) null, utilsKt$loadCustomExtractor$2$1$1$1$1, this, 8, (Object) null);
                    if (objNewExtractorLink$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objNewExtractorLink$default;
                    function1 = function2;
                    break;
                case 1:
                    function1 = (Function1) this.L$3;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(obj);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }
}
