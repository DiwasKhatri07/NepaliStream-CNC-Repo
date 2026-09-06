package com.Microtv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Microtv/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/Microtv/Gofile;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "mainApi", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AccountResponse", "AccountData", "GofileResponse", "GofileData", "GofileFile", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/Microtv/Gofile\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,348:1\n93#2,2:349\n63#2:351\n64#2,15:353\n95#2,2:370\n93#2,2:372\n63#2:374\n64#2,15:376\n95#2,2:393\n1#3:352\n1#3:375\n50#4:368\n43#4:369\n50#4:391\n43#4:392\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/Microtv/Gofile\n*L\n234#1:349,2\n234#1:351\n234#1:353,15\n234#1:370,2\n249#1:372,2\n249#1:374\n249#1:376,15\n249#1:393,2\n234#1:352\n249#1:375\n234#1:368\n234#1:369\n249#1:391\n249#1:392\n*E\n"})
public class Gofile extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Gofile";

    @NotNull
    private final String mainUrl = "https://gofile.io";

    @NotNull
    private final String mainApi = "https://api.gofile.io";

    /* JADX INFO: renamed from: com.Microtv.Gofile$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Gofile", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {234, 237, 245, 265}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this", "url", "referer", "subtitleCallback", "callback", "id", "token", "$this", "url", "referer", "subtitleCallback", "callback", "id", "token", "globalRes", "wt", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "id", "token", "globalRes", "wt", "headers", "rawJson", "parsedResponse", "childrenMap", "file", "fileName", "formattedSize", "size", "quality"}, nl = {349, 238, 248, 264}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "J$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Gofile.getUrl$suspendImpl(Gofile.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:140:0x053b  */
    /* JADX WARN: Code duplicated, block: B:142:0x054f  */
    /* JADX WARN: Code duplicated, block: B:146:0x0559  */
    /* JADX WARN: Code duplicated, block: B:148:0x055d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0584  */
    /* JADX WARN: Code duplicated, block: B:156:0x058c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0591  */
    /* JADX WARN: Code duplicated, block: B:160:0x059f  */
    /* JADX WARN: Code duplicated, block: B:161:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:164:0x060e  */
    /* JADX WARN: Code duplicated, block: B:171:0x0629  */
    /* JADX WARN: Code duplicated, block: B:175:0x06de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:176:0x06df  */
    /* JADX WARN: Code duplicated, block: B:214:0x057e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x06df -> B:177:0x06f8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.Microtv.Gofile r35, java.lang.String r36, java.lang.String r37, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 1904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Microtv.Gofile.getUrl$suspendImpl(com.Microtv.Gofile, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.Microtv.Gofile$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Gofile$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $token;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(int i, String str, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$quality = i;
            this.$token = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$quality, this.$token, continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Cookie", "accountToken=" + this.$token)));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Microtv/Gofile$AccountResponse;", "", "data", "Lcom/Microtv/Gofile$AccountData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Microtv/Gofile$AccountData;)V", "getData", "()Lcom/Microtv/Gofile$AccountData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AccountResponse {

        @Nullable
        private final AccountData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public AccountResponse() {
            AccountData accountData = null;
            this(accountData, 1, accountData);
        }

        public static /* synthetic */ AccountResponse copy$default(AccountResponse accountResponse, AccountData accountData, int i, Object obj) {
            if ((i & 1) != 0) {
                accountData = accountResponse.data;
            }
            return accountResponse.copy(accountData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AccountData getData() {
            return this.data;
        }

        @NotNull
        public final AccountResponse copy(@JsonProperty("data") @Nullable AccountData data) {
            return new AccountResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccountResponse) && Intrinsics.areEqual(this.data, ((AccountResponse) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AccountResponse(data=" + this.data + ')';
        }

        public AccountResponse(@JsonProperty("data") @Nullable AccountData data) {
            this.data = data;
        }

        public /* synthetic */ AccountResponse(AccountData accountData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : accountData);
        }

        @Nullable
        public final AccountData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/Microtv/Gofile$AccountData;", "", "token", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AccountData {

        @Nullable
        private final String token;

        /* JADX WARN: Illegal instructions before constructor call */
        public AccountData() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ AccountData copy$default(AccountData accountData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accountData.token;
            }
            return accountData.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final AccountData copy(@JsonProperty("token") @Nullable String token) {
            return new AccountData(token);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccountData) && Intrinsics.areEqual(this.token, ((AccountData) other).token);
        }

        public int hashCode() {
            if (this.token == null) {
                return 0;
            }
            return this.token.hashCode();
        }

        @NotNull
        public String toString() {
            return "AccountData(token=" + this.token + ')';
        }

        public AccountData(@JsonProperty("token") @Nullable String token) {
            this.token = token;
        }

        public /* synthetic */ AccountData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getToken() {
            return this.token;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/Microtv/Gofile$GofileResponse;", "", "data", "Lcom/Microtv/Gofile$GofileData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/Microtv/Gofile$GofileData;)V", "getData", "()Lcom/Microtv/Gofile$GofileData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GofileResponse {

        @Nullable
        private final GofileData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public GofileResponse() {
            GofileData gofileData = null;
            this(gofileData, 1, gofileData);
        }

        public static /* synthetic */ GofileResponse copy$default(GofileResponse gofileResponse, GofileData gofileData, int i, Object obj) {
            if ((i & 1) != 0) {
                gofileData = gofileResponse.data;
            }
            return gofileResponse.copy(gofileData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GofileData getData() {
            return this.data;
        }

        @NotNull
        public final GofileResponse copy(@JsonProperty("data") @Nullable GofileData data) {
            return new GofileResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GofileResponse) && Intrinsics.areEqual(this.data, ((GofileResponse) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "GofileResponse(data=" + this.data + ')';
        }

        public GofileResponse(@JsonProperty("data") @Nullable GofileData data) {
            this.data = data;
        }

        public /* synthetic */ GofileResponse(GofileData gofileData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : gofileData);
        }

        @Nullable
        public final GofileData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012$\b\u0003\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J/\u0010\r\u001a\u00020\u00002$\b\u0003\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/Microtv/Gofile$GofileData;", "", "children", "", "", "Lcom/Microtv/Gofile$GofileFile;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/Map;)V", "getChildren", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GofileData {

        @Nullable
        private final Map<String, GofileFile> children;

        /* JADX WARN: Illegal instructions before constructor call */
        public GofileData() {
            Map map = null;
            this(map, 1, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GofileData copy$default(GofileData gofileData, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = gofileData.children;
            }
            return gofileData.copy(map);
        }

        @Nullable
        public final Map<String, GofileFile> component1() {
            return this.children;
        }

        @NotNull
        public final GofileData copy(@JsonProperty("children") @Nullable Map<String, GofileFile> children) {
            return new GofileData(children);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GofileData) && Intrinsics.areEqual(this.children, ((GofileData) other).children);
        }

        public int hashCode() {
            if (this.children == null) {
                return 0;
            }
            return this.children.hashCode();
        }

        @NotNull
        public String toString() {
            return "GofileData(children=" + this.children + ')';
        }

        public GofileData(@JsonProperty("children") @Nullable Map<String, GofileFile> map) {
            this.children = map;
        }

        public /* synthetic */ GofileData(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map);
        }

        @Nullable
        public final Map<String, GofileFile> getChildren() {
            return this.children;
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011Jv\u0010\u0017\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/Microtv/Gofile$GofileFile;", "", "type", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "link", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getType", "()Ljava/lang/String;", "getName", "getLink", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/Microtv/Gofile$GofileFile;", "equals", "", "other", "hashCode", "", "toString", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class GofileFile {

        @Nullable
        private final String link;

        @Nullable
        private final String name;

        @Nullable
        private final Long size;

        @Nullable
        private final String type;

        public GofileFile() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ GofileFile copy$default(GofileFile gofileFile, String str, String str2, String str3, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gofileFile.type;
            }
            if ((i & 2) != 0) {
                str2 = gofileFile.name;
            }
            if ((i & 4) != 0) {
                str3 = gofileFile.link;
            }
            if ((i & 8) != 0) {
                l = gofileFile.size;
            }
            return gofileFile.copy(str, str2, str3, l);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getSize() {
            return this.size;
        }

        @NotNull
        public final GofileFile copy(@JsonProperty("type") @Nullable String type, @JsonProperty("name") @Nullable String name, @JsonProperty("link") @Nullable String link, @JsonProperty("size") @Nullable Long size) {
            return new GofileFile(type, name, link, size);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GofileFile)) {
                return false;
            }
            GofileFile gofileFile = (GofileFile) other;
            return Intrinsics.areEqual(this.type, gofileFile.type) && Intrinsics.areEqual(this.name, gofileFile.name) && Intrinsics.areEqual(this.link, gofileFile.link) && Intrinsics.areEqual(this.size, gofileFile.size);
        }

        public int hashCode() {
            return ((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.size != null ? this.size.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "GofileFile(type=" + this.type + ", name=" + this.name + ", link=" + this.link + ", size=" + this.size + ')';
        }

        public GofileFile(@JsonProperty("type") @Nullable String type, @JsonProperty("name") @Nullable String name, @JsonProperty("link") @Nullable String link, @JsonProperty("size") @Nullable Long size) {
            this.type = type;
            this.name = name;
            this.link = link;
            this.size = size;
        }

        public /* synthetic */ GofileFile(String str, String str2, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? 0L : l);
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final Long getSize() {
            return this.size;
        }
    }
}
