package com.Animeav1;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animeav1/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/Animeav1/Zilla;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animeav1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Zilla extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private String name = "HLS";

    @NotNull
    private String mainUrl = "https://player.zilla-networks.com";

    /* JADX INFO: renamed from: com.Animeav1.Zilla$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Zilla", f = "Extractor.kt", i = {0, 0, 0, 0}, l = {18}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "mp4"}, nl = {17}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Zilla.getUrl$suspendImpl(Zilla.this, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object getUrl$suspendImpl(Zilla $this, String url, String referer, Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00101 c00101;
        Object objNewExtractorLink;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = $this.new C00101(continuation);
            }
        } else {
            c00101 = $this.new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String mp4 = $this.getMainUrl() + "/m3u8/" + StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null);
                String name = $this.getName();
                String name2 = $this.getName();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C00112 c00112 = new C00112(referer, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable($this);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(mp4);
                c00102.label = 1;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, mp4, extractorLinkType, c00112, c00102);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.listOf(objNewExtractorLink);
    }

    /* JADX INFO: renamed from: com.Animeav1.Zilla$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animeav1.Zilla$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(String str, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$referer = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = new C00112(this.$referer, continuation);
            c00112.L$0 = obj;
            return c00112;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$referer;
                    if (str == null) {
                        str = "";
                    }
                    $this$newExtractorLink.setReferer(str);
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
