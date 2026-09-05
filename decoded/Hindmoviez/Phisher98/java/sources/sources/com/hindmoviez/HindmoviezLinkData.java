package com.hindmoviez;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/hindmoviez/HindmoviezLinkData;", "", "rawId", "", "domain", "ajaxUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRawId", "()Ljava/lang/String;", "getDomain", "getAjaxUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HindmoviezLinkData {

    @NotNull
    private final String ajaxUrl;

    @NotNull
    private final String domain;

    @NotNull
    private final String rawId;

    public static /* synthetic */ HindmoviezLinkData copy$default(HindmoviezLinkData hindmoviezLinkData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hindmoviezLinkData.rawId;
        }
        if ((i & 2) != 0) {
            str2 = hindmoviezLinkData.domain;
        }
        if ((i & 4) != 0) {
            str3 = hindmoviezLinkData.ajaxUrl;
        }
        return hindmoviezLinkData.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRawId() {
        return this.rawId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAjaxUrl() {
        return this.ajaxUrl;
    }

    @NotNull
    public final HindmoviezLinkData copy(@NotNull String rawId, @NotNull String domain, @NotNull String ajaxUrl) {
        return new HindmoviezLinkData(rawId, domain, ajaxUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HindmoviezLinkData)) {
            return false;
        }
        HindmoviezLinkData hindmoviezLinkData = (HindmoviezLinkData) other;
        return Intrinsics.areEqual(this.rawId, hindmoviezLinkData.rawId) && Intrinsics.areEqual(this.domain, hindmoviezLinkData.domain) && Intrinsics.areEqual(this.ajaxUrl, hindmoviezLinkData.ajaxUrl);
    }

    public int hashCode() {
        return (((this.rawId.hashCode() * 31) + this.domain.hashCode()) * 31) + this.ajaxUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "HindmoviezLinkData(rawId=" + this.rawId + ", domain=" + this.domain + ", ajaxUrl=" + this.ajaxUrl + ')';
    }

    public HindmoviezLinkData(@NotNull String rawId, @NotNull String domain, @NotNull String ajaxUrl) {
        this.rawId = rawId;
        this.domain = domain;
        this.ajaxUrl = ajaxUrl;
    }

    @NotNull
    public final String getRawId() {
        return this.rawId;
    }

    @NotNull
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    public final String getAjaxUrl() {
        return this.ajaxUrl;
    }
}
