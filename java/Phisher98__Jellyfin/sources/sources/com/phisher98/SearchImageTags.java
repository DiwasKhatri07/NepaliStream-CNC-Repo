package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0010\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/SearchImageTags;", "", "primary", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Primary", "logo", "Logo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPrimary", "()Ljava/lang/String;", "getLogo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchImageTags {

    @Nullable
    private final String logo;

    @Nullable
    private final String primary;

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchImageTags() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ SearchImageTags copy$default(SearchImageTags searchImageTags, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchImageTags.primary;
        }
        if ((i & 2) != 0) {
            str2 = searchImageTags.logo;
        }
        return searchImageTags.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPrimary() {
        return this.primary;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final SearchImageTags copy(@JsonProperty("Primary") @Nullable String primary, @JsonProperty("Logo") @Nullable String logo) {
        return new SearchImageTags(primary, logo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchImageTags)) {
            return false;
        }
        SearchImageTags searchImageTags = (SearchImageTags) other;
        return Intrinsics.areEqual(this.primary, searchImageTags.primary) && Intrinsics.areEqual(this.logo, searchImageTags.logo);
    }

    public int hashCode() {
        return ((this.primary == null ? 0 : this.primary.hashCode()) * 31) + (this.logo != null ? this.logo.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SearchImageTags(primary=" + this.primary + ", logo=" + this.logo + ')';
    }

    public SearchImageTags(@JsonProperty("Primary") @Nullable String primary, @JsonProperty("Logo") @Nullable String logo) {
        this.primary = primary;
        this.logo = logo;
    }

    public /* synthetic */ SearchImageTags(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getPrimary() {
        return this.primary;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }
}
