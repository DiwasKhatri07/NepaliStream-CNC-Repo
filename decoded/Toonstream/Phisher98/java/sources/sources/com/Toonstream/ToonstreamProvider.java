package com.Toonstream;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.extractors.EmturbovidExtractor;
import com.lagradost.cloudstream3.extractors.Vidmolyme;
import com.lagradost.cloudstream3.plugins.BasePlugin;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ToonstreamProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Toonstream/Phisher98/java/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/Toonstream/ToonstreamProvider;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "Companion", "Toonstream", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ToonstreamProvider extends BasePlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load() {
        registerMainAPI(new Toonstream());
        registerExtractorAPI((ExtractorApi) new StreamSB8());
        registerExtractorAPI((ExtractorApi) new Vidmolyme());
        registerExtractorAPI(new Streamruby());
        registerExtractorAPI((ExtractorApi) new D000d());
        registerExtractorAPI((ExtractorApi) new vidhidevip());
        registerExtractorAPI((ExtractorApi) new Cdnwish());
        registerExtractorAPI((ExtractorApi) new FileMoonnl());
        registerExtractorAPI((ExtractorApi) new Cloudy());
        registerExtractorAPI(new GDMirrorbot());
        registerExtractorAPI(new Techinmind());
        registerExtractorAPI((ExtractorApi) new EmturbovidExtractor());
        registerExtractorAPI(new Zephyrflick());
        registerExtractorAPI(new Abyass());
    }

    /* JADX INFO: compiled from: ToonstreamProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/Toonstream/ToonstreamProvider$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/Toonstream/ToonstreamProvider$Companion$Domains;", "getCachedDomains", "()Lcom/Toonstream/ToonstreamProvider$Companion$Domains;", "setCachedDomains", "(Lcom/Toonstream/ToonstreamProvider$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Domains", "Toonstream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nToonstreamProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToonstreamProvider.kt\ncom/Toonstream/ToonstreamProvider$Companion\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,52:1\n73#2,5:53\n*S KotlinDebug\n*F\n+ 1 ToonstreamProvider.kt\ncom/Toonstream/ToonstreamProvider$Companion\n*L\n38#1:53,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return ToonstreamProvider.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            ToonstreamProvider.cachedDomains = domains;
        }

        public static /* synthetic */ Object getDomains$default(Companion companion, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.getDomains(z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        @Nullable
        public final Object getDomains(boolean forceRefresh, @NotNull Continuation<? super Domains> continuation) {
            ToonstreamProvider$Companion$getDomains$1 toonstreamProvider$Companion$getDomains$1;
            Companion companion;
            Object safe;
            if (continuation instanceof ToonstreamProvider$Companion$getDomains$1) {
                toonstreamProvider$Companion$getDomains$1 = (ToonstreamProvider$Companion$getDomains$1) continuation;
                if ((toonstreamProvider$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    toonstreamProvider$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    toonstreamProvider$Companion$getDomains$1 = new ToonstreamProvider$Companion$getDomains$1(this, continuation);
                }
            } else {
                toonstreamProvider$Companion$getDomains$1 = new ToonstreamProvider$Companion$getDomains$1(this, continuation);
            }
            ToonstreamProvider$Companion$getDomains$1 toonstreamProvider$Companion$getDomains$2 = toonstreamProvider$Companion$getDomains$1;
            Object $result = toonstreamProvider$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (toonstreamProvider$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                toonstreamProvider$Companion$getDomains$2.L$0 = this;
                                toonstreamProvider$Companion$getDomains$2.Z$0 = forceRefresh;
                                toonstreamProvider$Companion$getDomains$2.label = 1;
                                try {
                                    $result = Requests.get$default(app, ToonstreamProvider.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, toonstreamProvider$Companion$getDomains$2, 4094, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion = this;
                                    try {
                                        NiceResponse this_$iv = (NiceResponse) $result;
                                        try {
                                            ResponseParser parser = this_$iv.getParser();
                                            Intrinsics.checkNotNull(parser);
                                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                                        } catch (Exception e$iv) {
                                            e$iv.printStackTrace();
                                            safe = null;
                                        }
                                        companion.setCachedDomains((Domains) safe);
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        return null;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    return null;
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        break;
                    }
                    return getCachedDomains();
                case 1:
                    boolean z = toonstreamProvider$Companion$getDomains$2.Z$0;
                    Companion companion2 = (Companion) toonstreamProvider$Companion$getDomains$2.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        companion = companion2;
                        NiceResponse this_$iv2 = (NiceResponse) $result;
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Domains.class));
                        companion.setCachedDomains((Domains) safe);
                        return getCachedDomains();
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        return null;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: ToonstreamProvider.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0002"}, d2 = {"Lcom/Toonstream/ToonstreamProvider$Companion$Domains;", "", "Toonstream", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "toonstream", "<init>", "(Ljava/lang/String;)V", "getToonstream", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @NotNull
            private final String Toonstream;

            public static /* synthetic */ Domains copy$default(Domains domains, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.Toonstream;
                }
                return domains.copy(str);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getToonstream() {
                return this.Toonstream;
            }

            @NotNull
            public final Domains copy(@JsonProperty("toonstream") @NotNull String Toonstream) {
                return new Domains(Toonstream);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Domains) && Intrinsics.areEqual(this.Toonstream, ((Domains) other).Toonstream);
            }

            public int hashCode() {
                return this.Toonstream.hashCode();
            }

            @NotNull
            public String toString() {
                return "Domains(Toonstream=" + this.Toonstream + ')';
            }

            public Domains(@JsonProperty("toonstream") @NotNull String Toonstream) {
                this.Toonstream = Toonstream;
            }

            @NotNull
            public final String getToonstream() {
                return this.Toonstream;
            }
        }
    }
}
