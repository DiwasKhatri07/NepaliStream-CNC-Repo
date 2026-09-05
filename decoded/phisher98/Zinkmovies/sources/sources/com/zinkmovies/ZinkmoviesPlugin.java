package com.zinkmovies;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.extractors.StreamTape;
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

/* JADX INFO: compiled from: ZinkmoviesPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Zinkmovies/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\b¨\u0006\u0007"}, d2 = {"Lcom/zinkmovies/ZinkmoviesPlugin;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "Companion", "Zinkmovies", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ZinkmoviesPlugin extends BasePlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    @Nullable
    private static Companion.Domains cachedDomains;

    public void load() {
        registerMainAPI(new Zinkmovies());
        registerExtractorAPI((ExtractorApi) new StreamTape());
        registerExtractorAPI(new HubCloud());
        registerExtractorAPI(new Hubdrive());
        registerExtractorAPI(new HUBCDN());
        registerExtractorAPI((ExtractorApi) new PixelDrainDev());
        registerExtractorAPI(new Hubcloudone());
        registerExtractorAPI(new TpiLi());
    }

    /* JADX INFO: compiled from: ZinkmoviesPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/zinkmovies/ZinkmoviesPlugin$Companion;", "", "<init>", "()V", "DOMAINS_URL", "", "cachedDomains", "Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;", "getCachedDomains", "()Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;", "setCachedDomains", "(Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;)V", "getDomains", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Domains", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nZinkmoviesPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZinkmoviesPlugin.kt\ncom/zinkmovies/ZinkmoviesPlugin$Companion\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,44:1\n73#2,5:45\n*S KotlinDebug\n*F\n+ 1 ZinkmoviesPlugin.kt\ncom/zinkmovies/ZinkmoviesPlugin$Companion\n*L\n30#1:45,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Domains getCachedDomains() {
            return ZinkmoviesPlugin.cachedDomains;
        }

        public final void setCachedDomains(@Nullable Domains domains) {
            ZinkmoviesPlugin.cachedDomains = domains;
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
            ZinkmoviesPlugin$Companion$getDomains$1 zinkmoviesPlugin$Companion$getDomains$1;
            Companion companion;
            Object safe;
            if (continuation instanceof ZinkmoviesPlugin$Companion$getDomains$1) {
                zinkmoviesPlugin$Companion$getDomains$1 = (ZinkmoviesPlugin$Companion$getDomains$1) continuation;
                if ((zinkmoviesPlugin$Companion$getDomains$1.label & Integer.MIN_VALUE) != 0) {
                    zinkmoviesPlugin$Companion$getDomains$1.label -= Integer.MIN_VALUE;
                } else {
                    zinkmoviesPlugin$Companion$getDomains$1 = new ZinkmoviesPlugin$Companion$getDomains$1(this, continuation);
                }
            } else {
                zinkmoviesPlugin$Companion$getDomains$1 = new ZinkmoviesPlugin$Companion$getDomains$1(this, continuation);
            }
            ZinkmoviesPlugin$Companion$getDomains$1 zinkmoviesPlugin$Companion$getDomains$2 = zinkmoviesPlugin$Companion$getDomains$1;
            Object $result = zinkmoviesPlugin$Companion$getDomains$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (zinkmoviesPlugin$Companion$getDomains$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (getCachedDomains() == null || forceRefresh) {
                        try {
                            Requests app = MainActivityKt.getApp();
                            try {
                                zinkmoviesPlugin$Companion$getDomains$2.L$0 = this;
                                zinkmoviesPlugin$Companion$getDomains$2.Z$0 = forceRefresh;
                                zinkmoviesPlugin$Companion$getDomains$2.label = 1;
                                try {
                                    $result = Requests.get$default(app, ZinkmoviesPlugin.DOMAINS_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, zinkmoviesPlugin$Companion$getDomains$2, 4094, (Object) null);
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
                    boolean z = zinkmoviesPlugin$Companion$getDomains$2.Z$0;
                    Companion companion2 = (Companion) zinkmoviesPlugin$Companion$getDomains$2.L$0;
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

        /* JADX INFO: compiled from: ZinkmoviesPlugin.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/zinkmovies/ZinkmoviesPlugin$Companion$Domains;", "", "hubcloud", "", "zinkmovies", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getHubcloud", "()Ljava/lang/String;", "getZinkmovies", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Domains {

            @Nullable
            private final String hubcloud;

            @Nullable
            private final String zinkmovies;

            /* JADX WARN: Illegal instructions before constructor call */
            public Domains() {
                String str = null;
                this(str, str, 3, str);
            }

            public static /* synthetic */ Domains copy$default(Domains domains, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = domains.hubcloud;
                }
                if ((i & 2) != 0) {
                    str2 = domains.zinkmovies;
                }
                return domains.copy(str, str2);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getZinkmovies() {
                return this.zinkmovies;
            }

            @NotNull
            public final Domains copy(@Nullable String hubcloud, @Nullable String zinkmovies) {
                return new Domains(hubcloud, zinkmovies);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Domains)) {
                    return false;
                }
                Domains domains = (Domains) other;
                return Intrinsics.areEqual(this.hubcloud, domains.hubcloud) && Intrinsics.areEqual(this.zinkmovies, domains.zinkmovies);
            }

            public int hashCode() {
                return ((this.hubcloud == null ? 0 : this.hubcloud.hashCode()) * 31) + (this.zinkmovies != null ? this.zinkmovies.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Domains(hubcloud=" + this.hubcloud + ", zinkmovies=" + this.zinkmovies + ')';
            }

            public Domains(@Nullable String hubcloud, @Nullable String zinkmovies) {
                this.hubcloud = hubcloud;
                this.zinkmovies = zinkmovies;
            }

            public /* synthetic */ Domains(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            @Nullable
            public final String getHubcloud() {
                return this.hubcloud;
            }

            @Nullable
            public final String getZinkmovies() {
                return this.zinkmovies;
            }
        }
    }
}
